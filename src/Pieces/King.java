package Pieces;

public class King extends Piece{

    public King(boolean isLight){
        super(isLight);
    }
    @Override
    public String getName(){
        String name = "king";
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
            return('K');
        }else{
            return('k');
        }

    }
    
}
