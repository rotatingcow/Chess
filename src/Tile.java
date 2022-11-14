import java.util.HashMap;
import java.util.Map;

public abstract class Tile {
    protected final int tileCoordinate;

    public Tile(int tileCoordinate){
        this.tileCoordinate = tileCoordinate;
    }


    private static final Map<Integer, EmptyTile> EMPTY_TILES = createAllPossibleEmptyTiles();
    

    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles(){
        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

        for(int i = 0; i<64; i++){
            emptyTileMap.put(i, new EmptyTile(i));
        }
        
        return emptyTileMap;
    }

    public static Tile createTile(int tileCoord, Piece piece){
        return piece != null ? new OccupiedTile(tileCoord, piece) : EMPTY_TILES.get(tileCoord);
    }


    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();


    public static final class EmptyTile extends Tile{
    
        public EmptyTile(final int tileCoordinate){
            super(tileCoordinate);
        }
        @Override
        public boolean isTileOccupied() {
            
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }


    }
    public static final class OccupiedTile extends Tile{
        private final Piece pieceOnTile;


        public OccupiedTile(final int tileCoordinate, Piece pieceOnTile){
            super(tileCoordinate);
            this.pieceOnTile = pieceOnTile;
        }
        @Override
        public boolean isTileOccupied() {
            return true;
        }
        @Override
        public Piece getPiece() {
            return this.pieceOnTile;
        }
    }




    
}
