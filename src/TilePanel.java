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
    //piece.getName()+"_"+piece.getColor()+".png"
    public TilePanel(Piece piece, int index){
        super(new GridBagLayout());
        this.setSize(80,80);

        this.isLight = (index % 2 == 0) ? true: false;
        System.out.print(index+" ");
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

        ImageIcon firstPng = new ImageIcon(new File("images/"+piece.getName()+"_"+piece.getColor()+".png").getAbsolutePath());   
        piecePng = new JLabel(new ImageIcon(firstPng.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
        this.add(piecePng);


       // validate();

    }



    public TilePanel(int index){

        final Dimension TILE_SIZE = new Dimension(80,80);
        setPreferredSize(TILE_SIZE);
        this.isLight = (index % 2 == 0) ? true: false;
        System.out.print(index+" ");
        this.num = index;
        this.empty = true;
        if(isLight){
            this.setBackground(new Color(255,248,238));
        }
        else{
            this.setBackground(new Color(102, 61, 20));
        }

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
