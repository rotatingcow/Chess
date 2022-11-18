import javax.swing.*;

import Pieces.Piece;


public class TilePanel extends JPanel{
    boolean Islight;
    boolean empty;
    Piece piece;
    int num;
    
    public TilePanel(Piece piece, int index){
        this.Islight = index-(index/8) % 2 == 0 ? true: false;
        this.num = index;
        this.empty = false;
        this.piece = piece;


    }

    public TilePanel(int index){
        this.Islight = index-(index/8) % 2 == 0 ? true: false;
        this.num = index;
        this.empty = true;
        


        
    }


    
}
