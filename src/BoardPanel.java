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

            for(int c=0; c < board[r].length ; c++){
                int row = r+1;
                int col = c+1;
                char currentChar = board[r][c];
                switch (currentChar){
                    case ' ': this.boardTiles.add(new TilePanel(row+col));
                        break;
                    case 'P': this.boardTiles.add(new TilePanel(new Pawn(true),row+col));
                        break;
                    case 'R': this.boardTiles.add(new TilePanel(new Rook(true),row+col));
                        break; 
                    case 'N': this.boardTiles.add(new TilePanel(new Knight(true),row+col));
                        break;  
                    case 'B': this.boardTiles.add(new TilePanel(new Bishop(true),row+col));
                        break;   
                    case 'Q': this.boardTiles.add(new TilePanel(new Queen(true),row+col));
                        break; 
                    case 'K': this.boardTiles.add(new TilePanel(new King(true),row+col));
                        break; 
                    case 'p': this.boardTiles.add(new TilePanel(new Pawn(false),row+col));
                        break;
                    case 'r': this.boardTiles.add(new TilePanel(new Rook(false),row+col));
                        break; 
                    case 'n': this.boardTiles.add(new TilePanel(new Knight(false),row+col));
                        break;  
                    case 'b': this.boardTiles.add(new TilePanel(new Bishop(false),row+col));
                        break;   
                    case 'q': this.boardTiles.add(new TilePanel(new Queen(false),row+col));
                        break; 
                    case 'k': this.boardTiles.add(new TilePanel(new King(false),row+col));
                        break;
                }
            }
        }
    }
    
}
