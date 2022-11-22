import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.swing.*;
import Pieces.*;


public class BoardPanel extends JPanel{
    List<TilePanel> boardTiles = null;

    public BoardPanel(char[][] board){
        super(new GridLayout(8,8));
        this.boardTiles = new ArrayList<TilePanel>();
        
        for(int r = 0; r < board.length; r++){
            System.out.println();
            for(int c=0; c < board[r].length ; c++){

                int row = r;
                int col = c+1;
                char currentChar = board[r][c];
                switch (currentChar){
                    case ' ': boardTiles.add(new TilePanel(row+col));
                        break;
                    case 'P': boardTiles.add(new TilePanel(new Pawn(true),row+col));
                        break;
                    case 'R': boardTiles.add(new TilePanel(new Rook(true),row+col));
                        break; 
                    case 'N': boardTiles.add(new TilePanel(new Knight(true),row+col));
                        break;  
                    case 'B': boardTiles.add(new TilePanel(new Bishop(true),row+col));
                        break;   
                    case 'Q': boardTiles.add(new TilePanel(new Queen(true),row+col));
                        break; 
                    case 'K': boardTiles.add(new TilePanel(new King(true),row+col));
                        break; 
                    case 'p': boardTiles.add(new TilePanel(new Pawn(false),row+col));
                        break;
                    case 'r': boardTiles.add(new TilePanel(new Rook(false),row+col));
                        break; 
                    case 'n': boardTiles.add(new TilePanel(new Knight(false),row+col));
                        break;  
                    case 'b': boardTiles.add(new TilePanel(new Bishop(false),row+col));
                        break;   
                    case 'q': boardTiles.add(new TilePanel(new Queen(false),row+col));
                        break; 
                    case 'k': boardTiles.add(new TilePanel(new King(false),row+col));
                        break;
                    default:
                        break;
                }
            }
        }
        for(int i = 0; i < boardTiles.size(); i++){
            TilePanel thing = boardTiles.get(i);
            this.add(thing);
        }
        validate();
    }

    public List<TilePanel> getboardTiles(){
        return boardTiles;
    }
    
}
