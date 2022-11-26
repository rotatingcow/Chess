
public class Moves {
    static long FILE_A=72340172838076673L;
    static long FILE_H=-9187201950435737472L;
    static long FILE_AB=217020518514230019L;
    static long FILE_GH=-4557430888798830400L;
    static long RANK_1=-72057594037927936L;
    static long RANK_4=1095216660480L;
    static long RANK_5=4278190080L;
    static long RANK_8=255L;
    static long CENTER=103481868288L;
    static long EXTENDED_CENTER=66229406269440L;
    static long KING_SIDE=-1085102592571150096L;
    static long QUEEN_SIDE=1085102592571150095L;
    static long KING_B7=460039L;
    static long KNIGHT_C6=43234889994L;
    static long NOT_WHITE_PIECES;
    static long BLACK_PIECES;
    static long EMPTY;
    static String tempList;

    public String possibleMovesW(String history,long WP,long WN,long WB,long WR,long WQ,long WK,long BP,long BN,long BB,long BR,long BQ,long BK) {
        NOT_WHITE_PIECES= ~(WP|WN|WB|WR|WQ|WK|BK);//added BK to avoid illegal capture
        BLACK_PIECES=BP|BN|BB|BR|BQ;//omitted BK to avoid illegal capture
        EMPTY=~(WP|WN|WB|WR|WQ|WK|BP|BN|BB|BR|BQ|BK);
        //timeExperiment(WP);
        String list=possiblePW(history,WP)/*+
                posibleNW(WP,WN,WB,WR,WQ,WK,BP,BN,BB,BR,BQ,BK)+
                posibleBW(WP,WN,WB,WR,WQ,WK,BP,BN,BB,BR,BQ,BK)+
                posibleRW(WP,WN,WB,WR,WQ,WK,BP,BN,BB,BR,BQ,BK)+
                posibleQW(WP,WN,WB,WR,WQ,WK,BP,BN,BB,BR,BQ,BK)+
                posibleKW(WP,WN,WB,WR,WQ,WK,BP,BN,BB,BR,BQ,BK)*/;
        return list;
    }

    public String getPossibleMovesReadable(String possibleMoves){
        String stringMoves = possibleMoves + " ";
        String finalList = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int phrases = possibleMoves.length()/4;
        for(int i = 0; i < phrases; i++){
            String syllableOne = "";
            String syllableTwo = "";
            String syllableThree = "";
            String syllableFour = "";
            for(int c = 0; c < 4; c++){
                char charAt = (i != 0) ? stringMoves.charAt(((i*4))+c) : stringMoves.charAt(c);
                int numAt = charAt - ' ' - 16;
                switch(c){
                    case  0 : syllableTwo = ""+ Math.abs((numAt-8));
                        break;
                    case 1 : syllableOne = alphabet.substring((charAt - ' ') - 16, (charAt - ' ')- 15);
                        break;
                    case 2 : syllableFour = ""+ Math.abs((numAt-8));
                        break;
                    case 3 : syllableThree = alphabet.substring((charAt - ' ') - 16, (charAt - ' ')- 15);
                        break;
                }
            }
            finalList += syllableOne+syllableTwo + " to " + syllableThree+syllableFour+"| ";
        }
        return(finalList);
    }



    
    public static String possiblePW(String history, long WP){
        String list = "";
        //Capture Right

        
        long PawnMoves=(WP>>7)& BLACK_PIECES& ~RANK_8& ~FILE_A;//capture right
        
        long possibility= PawnMoves&~(PawnMoves-1);
        while (possibility != 0){
            int index=Long.numberOfTrailingZeros(possibility);
            
            list+=""+((index/8)+1)+((index%8)-1)+(index/8)+(index%8);
            PawnMoves&=~(possibility);
            possibility=PawnMoves&~(PawnMoves-1);
        }

        //Capture Left
        PawnMoves = (WP>>9) & BLACK_PIECES & ~FILE_A & ~RANK_8;
        possibility= PawnMoves&~(PawnMoves-1);
        while (possibility != 0){
            int index=Long.numberOfTrailingZeros(possibility);
            
            list+=""+((index/8)+1)+((index%8)+1)+(index/8)+(index%8);
            PawnMoves&=~(possibility);
            possibility=PawnMoves&~(PawnMoves-1);
        }
        
        //Move Up 1
        PawnMoves = (WP>>8) & EMPTY & ~RANK_8;
        possibility= PawnMoves&~(PawnMoves-1);
        while (possibility != 0){
            int index=Long.numberOfTrailingZeros(possibility);
            
            list+=""+((index/8)+1)+((index%8))+(index/8)+(index%8);
            PawnMoves&=~(possibility);
            possibility=PawnMoves&~(PawnMoves-1);
        }

        //Move Up 2
        PawnMoves = (WP>>16) & EMPTY & (EMPTY>>8) & RANK_4;
        possibility= PawnMoves&~(PawnMoves-1);
        while (possibility != 0){
            int index=Long.numberOfTrailingZeros(possibility);
             
            list+=""+((index/8)+2)+((index%8))+(index/8)+(index%8);
            PawnMoves&=~(possibility);
            possibility=PawnMoves&~(PawnMoves-1);
        }





        //Capture right promote
        PawnMoves = (WP >> 7) & BLACK_PIECES & ~FILE_H & RANK_8;
        for(int i = Long.numberOfTrailingZeros(PawnMoves); i < Long.numberOfLeadingZeros(PawnMoves); i++){
            if((PawnMoves>>i&1 ) == 1) {
                list+=""+(i/8+1)+((i%8)+1)+"QP"+(i%8-1)+(i%8)+"RP"+(i%8-1)+(i%8)+"BP"+(i%8-1)+(i%8)+"NP";
            }
        }



        //Capture left promote
        PawnMoves = (WP >> 9 ) & BLACK_PIECES & ~FILE_A & RANK_8;
        for(int i = Long.numberOfTrailingZeros(PawnMoves); i < Long.numberOfLeadingZeros(PawnMoves); i++){
            if((PawnMoves>>i&1) == 1){
                list += ""+((i/8)+1)+((i%8)-1)+"QP"+(i%8+1)+(i%8)+"RP"+(i%8+1)+(i%8)+"BP"+(i%8+1)+(i%8)+"NP";
            }
        }



        //Move Up Promote
        PawnMoves = (WP>>8) & EMPTY & RANK_8;
        for(int i = Long.numberOfTrailingZeros(PawnMoves); i < Long.numberOfLeadingZeros(PawnMoves); i++){
            if((PawnMoves>>i&1) == 1){
                list += ""+(i/8+1)+(i%8)+"QP"+(i%8)+(i%8)+"RP"+(i%8)+(i%8)+"BP"+(i%8)+(i%8)+"NP";
            }
        }


        //TODO add En Passant :(
        return(list);
    }


    /* *
    public static void timeExperiment(long WP) {
        int loopLength=1000;
        long startTime=System.currentTimeMillis();
        tEMethodA(loopLength, WP);
        long endTime=System.currentTimeMillis();
        System.out.println("That took "+(endTime-startTime)+" milliseconds for the first method");
        startTime=System.currentTimeMillis();
        tEMethodB(loopLength, WP);
        endTime=System.currentTimeMillis();
        System.out.println("That took "+(endTime-startTime)+" milliseconds for the second method");
    }

    public static void tEMethodA(int loopLength, long WP) {
        for (int loop=0;loop<loopLength;loop++){}
    {
            long PAWN_MOVES=(WP>>7)&BLACK_PIECES&~RANK_8&~FILE_A;//capture right
            String list="";
            for (int i=0;i<64;i++) {
                if (((PAWN_MOVES>>i)&1)==1) {
                    list+=""+(i/8+1)+(i%8-1)+(i/8)+(i%8);
                }
            }
        }
    }
    public static void tEMethodB(int loopLength, long WP) {
        for (int loop=0;loop<loopLength;loop++)
        {
            long PawnMoves=(WP>>7)&BLACK_PIECES&~RANK_8&~FILE_A;//capture right
            String list="";
            long possibility= PawnMoves&~(PawnMoves-1);
            while (possibility != 0)
            {
                int index=Long.numberOfTrailingZeros(possibility);
                list+=""+(index/8+1)+(index%8-1)+(index/8)+(index%8);
                PawnMoves&=~(possibility);
                possibility=PawnMoves&~(PawnMoves-1);
            }
        }
    }
    */
}
