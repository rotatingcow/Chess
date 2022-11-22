package Pieces;
public abstract class Piece {
    boolean isLight;


    public Piece(boolean light){
        isLight = light;

    }

    public abstract String getName();

    public abstract String getColor();

    public abstract char getChar();
    
}
