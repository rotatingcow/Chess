package Pieces;

public class Pawn extends Piece {
    public Pawn(boolean isLight){
        super(isLight);
    }
    @Override
    public String getName(){
        String name = "pawn";
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
}
