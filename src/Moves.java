
public class Moves {
    static long FILE_A=72340172838076673L;
    static long FILE_H=-9187201950435737472L;
    static long FILE_AB=217020518514230019L;
    static long FILE_GH=-4557430888798830400L;
    static long RANK_1=-72057594037927936L;
    static long RANK_4=1095216660480L;
    static long RANK_5=4278190080L;
    static long RANK_8=255L;
    static long CENTRE=103481868288L;
    static long EXTENDED_CENTRE=66229406269440L;
    static long KING_SIDE=-1085102592571150096L;
    static long QUEEN_SIDE=1085102592571150095L;
    static long KING_B7=460039L;
    static long KNIGHT_C6=43234889994L;
    static long NOT_WHITE_PIECES;
    static long BLACK_PIECES;
    static long EMPTY;
    static String tempList;

    public static String possibleMovesW(String history,long WP,long WN,long WB,long WR,long WQ,long WK,long BP,long BN,long BB,long BR,long BQ,long BK) {
        NOT_WHITE_PIECES=~(WP|WN|WB|WR|WQ|WK|BK);//added BK to avoid illegal capture
        BLACK_PIECES=BP|BN|BB|BR|BQ;//omitted BK to avoid illegal capture
        EMPTY=~(WP|WN|WB|WR|WQ|WK|BP|BN|BB|BR|BQ|BK);
        
        String list=possiblePW(history,WP)/*+
                posibleNW(WP,WN,WB,WR,WQ,WK,BP,BN,BB,BR,BQ,BK)+
                posibleBW(WP,WN,WB,WR,WQ,WK,BP,BN,BB,BR,BQ,BK)+
                posibleRW(WP,WN,WB,WR,WQ,WK,BP,BN,BB,BR,BQ,BK)+
                posibleQW(WP,WN,WB,WR,WQ,WK,BP,BN,BB,BR,BQ,BK)+
                posibleKW(WP,WN,WB,WR,WQ,WK,BP,BN,BB,BR,BQ,BK)*/;


        
        
        return list;
    }

    public static String possiblePW(String history, long WP){
        String list = "";
        //Capture Right
        long PawnMoves = (WP>>7)& BLACK_PIECES & ~FILE_H & ~ RANK_8;
        
        for(int i = Long.numberOfTrailingZeros(PawnMoves); i < Long.numberOfLeadingZeros(PawnMoves); i++){
            if((PawnMoves>>i&1 ) == 1) {
                list += ""+ ((i/8)-1)+((i%8)-1)+(i/8)+(i%8);
            }
        }

        //Capture Left
        PawnMoves = (WP>>9) & BLACK_PIECES & ~FILE_A & ~RANK_8;
        for(int i = Long.numberOfTrailingZeros(PawnMoves); i < Long.numberOfLeadingZeros(PawnMoves); i++){
            if((PawnMoves>>i&1 ) == 1) {
                list += ""+ ((i/8)-1)+((i%8)-1)+(i/8)+(i%8);
            }

        }

        //Move Up 1
        PawnMoves = (WP>>8) & EMPTY & ~RANK_8;
        for(int i = Long.numberOfTrailingZeros(PawnMoves); i < Long.numberOfLeadingZeros(PawnMoves); i++){
            if((PawnMoves>>i&1 ) == 1) {
                list += ""+ ((i/8)-1)+((i%8))+(i/8)+(i%8);
            }
        }


        //Move Up 2
        PawnMoves = (WP>>16) & EMPTY & (EMPTY>>8) & RANK_4;
        for(int i = Long.numberOfTrailingZeros(PawnMoves); i < Long.numberOfLeadingZeros(PawnMoves); i++){
            if((PawnMoves>>i&1 ) == 1) {
                list += ""+ ((i/8)-2)+((i%8))+(i/8)+(i%8);
            }
        }

        //En Passant :(
        return(list);
    }



    
}
