import javax.swing.*;


import java.awt.*;
import Pieces.Piece;
//import images.*;
import java.io.File;


public class TilePanel extends JPanel{
    boolean isLight;
    boolean empty;
    Piece piece;
    int num;
    JLabel piecePng;
    //piece.getName()+"_"+piece.getColor()+"png"
    public TilePanel(Piece piece, int index){
        super(new GridBagLayout());
        this.setSize(80,80);

        

        this.isLight = (index+(index/8)) % 2 == 0 ? true: false;
        //System.out.print("ASA");
        this.num = index;
        this.empty = false;
        this.piece = piece;
        //System.out.print(isLight+ " ");
        if(isLight){
            this.setBackground(new Color(255,248,238));
        }
        else{
            this.setBackground(new Color(102, 61, 20));
        }

        piecePng = new JLabel(new ImageIcon(new File("rook_black.png").getAbsolutePath()));
        System.out.println(this.getSize());
        this.add(piecePng);
        //this.setSize(80,80);
        //this.setVisible(true);

        validate();

    }

    public TilePanel(int index){
        final Dimension TILE_SIZE = new Dimension(80,80);
        setPreferredSize(TILE_SIZE);
        this.isLight = (index+(index/8)) % 2 == 0 ? true: false;
        //System.out.print(index+" ");
        this.num = index;
        this.empty = true;
        //System.out.print(isLight+ " ");
        if(isLight){
            this.setBackground(new Color(255,248,238));
        }
        else{
            this.setBackground(new Color(102, 61, 20));
        }
        System.out.println(this.getSize());
        //this.setVisible(true);

    }

    public String getInfo(){
        if(empty){
            return("_");
        }
        else{
            return(piece.getName());
        }
    }

    
}
