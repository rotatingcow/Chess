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
    @Override
    public char getChar(){
        if(isLight){
            return('Q');
        }else{
            return('q');
        }

    }
}
