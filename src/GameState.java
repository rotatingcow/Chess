

public class GameState{
    public long WP, WR, WN, WB, WQ, WK, BP, BR, BN, BB, BQ, BK;
    public boolean whiteCanQCastle;
    public boolean whiteCanKCastle;
    public boolean blackCanQCastle;
    public boolean blackCanKCastle;

    public long NOT_WHITE_PIECES;
    public long BLACK_PIECES;
    public long WHITE_PIECES;
    public long NOT_BLACK_PIECES;
    public long OCCUPIED;
    public long EMPTY;


    public GameState(long WP, long WR, long WN, long WB, long WQ, long WK, long BP, long BR, long BN, long BB, long BQ, long BK){
        
    }

    public GameState(){
        WP = Board.WP;
        WR = Board.WR;
        WN = Board.WN;
        WB = Board.WB;
        WQ = Board.WQ;
        WK = Board.WK;
        BP = Board.BP;
        BR = Board.BR;
        BN = Board.BN;
        BB = Board.BB;
        BQ = Board.BQ;
        BK = Board.BK;
        NOT_WHITE_PIECES= ~(WP|WN|WB|WR|WQ|WK|BK);//added BK to avoid illegal capture
        BLACK_PIECES=BP|BN|BB|BR|BQ;//omitted BK to avoid illegal capture
        WHITE_PIECES = WP|WN|WB|WR|WQ;//omitted WK to ovaid illegal capture
        NOT_BLACK_PIECES = ~(BP|BN|BB|BR|BQ|WK);
        OCCUPIED=WP|WN|WB|WR|WQ|WK|BP|BN|BB|BR|BQ|BK;
        EMPTY=~OCCUPIED;
    }

    public void updateBitboards(){
        WP = Board.WP;
        WR = Board.WR;
        WN = Board.WN;
        WB = Board.WB;
        WQ = Board.WQ;
        WK = Board.WK;
        BP = Board.BP;
        BR = Board.BR;
        BN = Board.BN;
        BB = Board.BB;
        BQ = Board.BQ;
        BK = Board.BK;
        NOT_WHITE_PIECES= ~(WP|WN|WB|WR|WQ|WK|BK);//added BK to avoid illegal capture
        BLACK_PIECES = BP|BN|BB|BR|BQ;//omitted BK to avoid illegal capture
        WHITE_PIECES = WP|WN|WB|WR|WQ;//omitted WK to ovaid illegal capture
        NOT_BLACK_PIECES = ~(BP|BN|BB|BR|BQ|WK);
        OCCUPIED = WP|WN|WB|WR|WQ|WK|BP|BN|BB|BR|BQ|BK;
        EMPTY = ~OCCUPIED;
    }

    public void updateBitboards(long[] newBitboards){
        WP = newBitboards[0];
        WR = newBitboards[1];
        WN = newBitboards[2];
        WB = newBitboards[3];
        WQ = newBitboards[4];
        WK = newBitboards[5];
        BP = newBitboards[6];
        BR = newBitboards[7];
        BN = newBitboards[8];
        BB = newBitboards[9];
        BQ = newBitboards[10];
        BK = newBitboards[11];
        NOT_WHITE_PIECES= ~(WP|WN|WB|WR|WQ|WK|BK);//added BK to avoid illegal capture
        BLACK_PIECES=BP|BN|BB|BR|BQ;//omitted BK to avoid illegal capture
        WHITE_PIECES = WP|WN|WB|WR|WQ;//omitted WK to ovaid illegal capture
        NOT_BLACK_PIECES = ~(BP|BN|BB|BR|BQ|WK);
        OCCUPIED=WP|WN|WB|WR|WQ|WK|BP|BN|BB|BR|BQ|BK;
        EMPTY=~OCCUPIED;
    }

}
