package Pieces;

public class Knight extends Piece {
    public Knight(boolean isLight){
        super(isLight);
    }
    @Override
    public String getName(){
        String name = "knight";
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
