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
    private String toMove = "white";
    private String startingSquare;
    private String endingSquare;
    private int moveNum;
    private String lastMove = "8877";
    Moves moves = new Moves();

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

    public void setToMove(boolean whiteToMove){
        if(whiteToMove){
            toMove = "white";
            moveNum += 1;
        }else{
            toMove = "black";
        }
    }

    public void changeToMove(){
        if(toMove == "white"){
            toMove = "black";
        }else{
            toMove = "white";
        }
    }

    public void makeMove(String move){
        int firstSquare = ((move.charAt(0) - '0') * 8) + (move.charAt(1) - '0');
        int secondSquare = ((move.charAt(2) - '0') * 8) + (move.charAt(3) - '0');
        Piece firstPiece = boardTiles.get(firstSquare).getRealPiece();
        System.out.println(move);
        System.out.println(lastMove);
        System.out.println(moves.isLegal(lastMove, move));
        if(firstSquare != secondSquare){
            boardTiles.get(firstSquare).setPiece(null);
            boardTiles.get(secondSquare).setPiece(firstPiece);
            boardTiles.get(secondSquare).revalidate();
            boardTiles.get(firstSquare).revalidate();
            changeToMove();
        }
        lastMove = move;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        for(int x = 0; x < boardTiles.size(); x++){
            if(boardTiles.get(x).getMousePosition() != null){
                
                if(firstClick){
                    if(boardTiles.get(x).getRealPiece().getColor() == toMove){
                        if(boardTiles.get(x).getRealPiece() != null){
                            startingSquare = ((""+(boardTiles.get(x).getTileIndex()/8))+""+((boardTiles.get(x).getTileIndex()%8)));
                            firstClick = false;
                        }
                    }
                }else{
                    if(moveNum == 5){
                        
                    }
                    endingSquare = ((""+(boardTiles.get(x).getTileIndex()/8))+""+((boardTiles.get(x).getTileIndex()%8)));
                    String move = startingSquare + endingSquare;
                    makeMove(move);
                    firstClick = true;
                }
                        
            }

        }
    }
        
        
    
        
        
    
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        
    }
    @Override
    public void mouseMoved(MouseEvent e) {

    }
    
}
