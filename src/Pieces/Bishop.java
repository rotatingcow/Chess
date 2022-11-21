package Pieces;

public class Bishop extends Piece{

    public Bishop(boolean isLight){
        super(isLight);
    }

    @Override
    public String getName(){
        String name = "bishop";
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
