import javax.swing.*;
import java.awt.*;
import Pieces.Piece;
import java.io.File;



public class TilePanel extends JPanel{

    boolean isLight;
    boolean empty;
    Piece piece;
    int num;
    int tileIndex;
    JLabel piecePng;

    public TilePanel(Piece piece, int index, int tileNum){
        super(new GridBagLayout());
        //this.setSize(80,80);


        this.isLight = (index % 2 == 0) ? true: false;
        this.tileIndex = tileNum;
        this.num = index;
        this.empty = false;
        this.piece = piece;

        if(isLight){
            this.setBackground(new Color(255,248,238));
        }
        else{
            this.setBackground(new Color(102, 61, 20));
        }



        ImageIcon firstPng = new ImageIcon(new File("images/"+piece.getName()+"_"+piece.getColor()+".png").getAbsolutePath());   
        piecePng = new JLabel(new ImageIcon(firstPng.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
        this.add(piecePng);

    }



    public TilePanel(int index, int tileNum){

        this.isLight = (index % 2 == 0) ? true: false;
        this.num = index;
        this.empty = true;
        this.tileIndex = tileNum;
        

        if(isLight){
            this.setBackground(new Color(255,248,238));
        }
        else{
            this.setBackground(new Color(102, 61, 20));
        }
    }

    public String getInfo(){
        if(empty){
            return("_");
        }
        else{
            return(piece.getName());
        }
    }

    public int getTileIndex(){
        return(this.tileIndex);
    }

    public char getPiece(){
        
        if(this.piece != null){
            return(piece.getChar());
        }else{
            return(' ');
        }
        
    }

}
