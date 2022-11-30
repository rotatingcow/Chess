import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.MouseInputListener;


import Pieces.*;


public class BoardPanel extends JPanel implements MouseInputListener{
    List<TilePanel> boardTiles = null;
    private boolean firstClick = true;
    private Piece piece = null;
    private TilePanel firstTile = null;
    JLabel coords = new JLabel("here!");

    public BoardPanel(char[][] board){
        
        super(new GridLayout(8,8));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.boardTiles = new ArrayList<TilePanel>();
        
        for(int r = 0; r < board.length; r++){
            System.out.println();
            for(int c=0; c < board[r].length ; c++){

                int row = r;
                int col = c;
                char currentChar = board[r][c];
                switch (currentChar){
                    case ' ': boardTiles.add(new TilePanel(row+col, (r*8)+c ));
                        break;
                    case 'P': boardTiles.add(new TilePanel(new Pawn(true),row+col, (r*8)+c));
                        break;
                    case 'R': boardTiles.add(new TilePanel(new Rook(true),row+col, (r*8)+c));
                        break; 
                    case 'N': boardTiles.add(new TilePanel(new Knight(true),row+col, (r*8)+c));
                        break;  
                    case 'B': boardTiles.add(new TilePanel(new Bishop(true),row+col, (r*8)+c));
                        break;   
                    case 'Q': boardTiles.add(new TilePanel(new Queen(true),row+col, (r*8)+c));
                        break; 
                    case 'K': boardTiles.add(new TilePanel(new King(true),row+col, (r*8)+c));
                        break; 
                    case 'p': boardTiles.add(new TilePanel(new Pawn(false),row+col, (r*8)+c));
                        break;
                    case 'r': boardTiles.add(new TilePanel(new Rook(false),row+col, (r*8)+c));
                        break; 
                    case 'n': boardTiles.add(new TilePanel(new Knight(false),row+col, (r*8)+c));
                        break;  
                    case 'b': boardTiles.add(new TilePanel(new Bishop(false),row+col, (r*8)+c));
                        break;   
                    case 'q': boardTiles.add(new TilePanel(new Queen(false),row+col, (r*8)+c));
                        break; 
                    case 'k': boardTiles.add(new TilePanel(new King(false),row+col, (r*8)+c));
                        break;
                    default:
                        break;
                }
            }
        }
        //this.add(coords);
        for(int i = 0; i < boardTiles.size(); i++){
            TilePanel thing = boardTiles.get(i);
            this.add(thing);
            
        }
       
        validate();
    }

    public List<TilePanel> getboardTiles(){
        return boardTiles;
    }

    public char[][] getBoardPos(){
        char[][] board = new char[8][8];

        for(int i = 0; i < 64; i++){
            char currentPiece = boardTiles.get(i).getPiece();
            int row = i/8;
            int column = i%8;

            board[row][column] = currentPiece;
        }

        return(board);
    }




    @Override
    public void mouseClicked(MouseEvent e) {
        int row = e.getX()/80;
        int col = e.getY()/80;
        System.out.println(row + " "+ col);
        
        //coords.setText("+"+row);
        for(int x = 0; x < boardTiles.size(); x++){
            if(boardTiles.get(x).getMousePosition() != null){
                if(firstClick){
                    System.out.println(boardTiles.get(x).getRealPiece() != null);
                    if(boardTiles.get(x).getRealPiece() != null){
                        firstTile = boardTiles.get(x);
                        piece = boardTiles.get(x).getRealPiece();
                        System.out.println(piece.getChar());
                        firstClick = false;
                    }
                }else{
                    System.out.println("NOT FIRST CLICK");
                    if(piece != null){
                        System.out.println("yoyoyo");
                        boardTiles.get(x).setPiece(piece);
                        firstTile.setPiece(null);
                        boardTiles.get(x).revalidate();
                        firstTile.revalidate();
                        piece = null;
                        firstClick = true;
                    }
                    
                }
               
                
                //coords.setLocation(new Point((int)getMousePosition().getX(), (int) getMousePosition().getY()));
               // coords.setText(""+(int)getMousePosition().getX()/80+ " "+  (int) getMousePosition().getY()/80);
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
}
