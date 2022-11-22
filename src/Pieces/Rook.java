package Pieces;

public class Rook extends Piece {

    public Rook(boolean isLight){
        super(isLight);
    }
    @Override
    public String getName(){
        String name = "rook";
        return(name);
    }

    @Override
    public String getColor(){
        if(isLight){
            return("white");
        }
        else{
            return("black");
        }
    }
    @Override
    public char getChar(){
        if(isLight){
            return('R');
        }else{
            return('r');
        }

    }

}
