package Pieces;

public class Queen extends Piece {
    public Queen(boolean isLight){
        super(isLight);
    }
    @Override
    public String getName(){
        String name = "queen";
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
