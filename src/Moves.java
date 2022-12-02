import java.util.Arrays;

public class Moves {

    // Correspond to areas of boards on 64 digit long binary string.
    static final long FILE_A=72340172838076673L;
    static final long FILE_H=-9187201950435737472L;
    static final  long FILE_AB=217020518514230019L;
    static final  long FILE_GH=-4557430888798830400L;
    static final  long RANK_1=-72057594037927936L;
    static final  long RANK_4=1095216660480L;
    static final  long RANK_5=4278190080L;
    static final  long RANK_8=255L;
    static final  long CENTER=103481868288L;
    static final  long EXTENDED_CENTER=66229406269440L;
    static final  long KING_SIDE=-1085102592571150096L;
    static final  long QUEEN_SIDE=1085102592571150095L;
    static final  long KING_RANGE=460039L;
    static final  long KNIGHT_RANGE=43234889994L;
    static long NOT_WHITE_PIECES;
    static long BLACK_PIECES;
    static long OCCUPIED;
    static long EMPTY;
    static String tempList;
    private static String list;
    static long RankMasks8[] =/*from rank1 to rank8*/
    {
        0xFFL, 0xFF00L, 0xFF0000L, 0xFF000000L, 0xFF00000000L, 0xFF0000000000L, 0xFF000000000000L, 0xFF00000000000000L
    };
    static long FileMasks8[] =/*from fileA to FileH*/
    {
        0x101010101010101L, 0x202020202020202L, 0x404040404040404L, 0x808080808080808L,
        0x1010101010101010L, 0x2020202020202020L, 0x4040404040404040L, 0x8080808080808080L
    };
    static long DiagonalMasks8[] =/*from top left to bottom right*/
    {
	0x1L, 0x102L, 0x10204L, 0x1020408L, 0x102040810L, 0x10204081020L, 0x1020408102040L,
	0x102040810204080L, 0x204081020408000L, 0x408102040800000L, 0x810204080000000L,
	0x1020408000000000L, 0x2040800000000000L, 0x4080000000000000L, 0x8000000000000000L
    };
    static long AntiDiagonalMasks8[] =/*from top right to bottom left*/
    {
	0x80L, 0x8040L, 0x804020L, 0x80402010L, 0x8040201008L, 0x804020100804L, 0x80402010080402L,
	0x8040201008040201L, 0x4020100804020100L, 0x2010080402010000L, 0x1008040201000000L,
	0x804020100000000L, 0x402010000000000L, 0x201000000000000L, 0x100000000000000L
    };

    static long HorizontalAndVerticalMoves(int s)
    {
        long binaryS=1L<<s;
        long possibilitiesHorizontal = (OCCUPIED - 2 * binaryS) ^ Long.reverse(Long.reverse(OCCUPIED) - 2 * Long.reverse(binaryS));
        long possibilitiesVertical = ((OCCUPIED&FileMasks8[s % 8]) - (2 * binaryS)) ^ Long.reverse(Long.reverse(OCCUPIED&FileMasks8[s % 8]) - (2 * Long.reverse(binaryS)));
        //drawBitboard((possibilitiesHorizontal&RankMasks8[s / 8]) | (possibilitiesVertical&FileMasks8[s % 8]));
        return (possibilitiesHorizontal&RankMasks8[s / 8]) | (possibilitiesVertical&FileMasks8[s % 8]);
    }
    static long DiagAndAntiDiagMoves(int s)
    {
        long binaryS=1L<<s;
        long possibilitiesDiagonal = ((OCCUPIED&DiagonalMasks8[(s / 8) + (s % 8)]) - (2 * binaryS)) ^ Long.reverse(Long.reverse(OCCUPIED&DiagonalMasks8[(s / 8) + (s % 8)]) - (2 * Long.reverse(binaryS)))&NOT_WHITE_PIECES;
        long possibilitiesAntiDiagonal = ((OCCUPIED&AntiDiagonalMasks8[(s / 8) + 7 - (s % 8)]) - (2 * binaryS)) ^ Long.reverse(Long.reverse(OCCUPIED&AntiDiagonalMasks8[(s / 8) + 7 - (s % 8)]) - (2 * Long.reverse(binaryS)))&NOT_WHITE_PIECES;
        return (possibilitiesDiagonal&DiagonalMasks8[(s / 8) + (s % 8)]) | (possibilitiesAntiDiagonal&AntiDiagonalMasks8[(s / 8) + 7 - (s % 8)]);
    }

    public String possibleMovesW(String history,long WP,long WN,long WB,long WR,long WQ,long WK,long BP,long BN,long BB,long BR,long BQ,long BK) {
        NOT_WHITE_PIECES= ~(WP|WN|WB|WR|WQ|WK|BK);//added BK to avoid illegal capture
        BLACK_PIECES=BP|BN|BB|BR|BQ;//omitted BK to avoid illegal capture
        EMPTY=~(WP|WN|WB|WR|WQ|WK|BP|BN|BB|BR|BQ|BK);
        OCCUPIED=WP|WN|WB|WR|WQ|WK|BP|BN|BB|BR|BQ|BK;
        EMPTY=~OCCUPIED;
        
        //drawBitboard(DiagAndAntiDiagMoves(36));
        //timeExperiment(WP);
        list=//+
            possibleNW(OCCUPIED,WN)+
            possiblePW(history,WP,BP)+
            possibleBW(OCCUPIED,WB)+
            possibleRW(OCCUPIED, WR)+
            possibleQW(OCCUPIED,WQ)+
            possibleKW(OCCUPIED, WK);

        unsafeForBlack(WP, WN, WB, WR, WQ, WK, BP, BN, BB, BR, BQ, BK);
        return list;
    }

    

    public boolean isLegal(String lastMove, String move){
        //possibleMovesW(move, NOT_WHITE_PIECES, KNIGHT_C6, KING_SIDE, KING_B7, FILE_H, FILE_GH, FILE_AB, FILE_A, EXTENDED_CENTER, EMPTY, CENTER, BLACK_PIECES);
        String legalMoves = list;
        System.out.println(getPossibleMovesReadable(legalMoves));
        boolean isLegal = (legalMoves.contains(move)) ? true : false;
        return isLegal;
        
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

    public static String possibleNW(long OCCUPIED,long WN)
    {
        String list="";
        long i=WN&~(WN-1);
        long possibility;
        while(i != 0)
        {
            int iLocation=Long.numberOfTrailingZeros(i);
            if (iLocation>18)
            {
                possibility=KNIGHT_RANGE<<(iLocation-18);
            }
            else {
                possibility=KNIGHT_RANGE>>(18-iLocation);
            }
            if (iLocation%8<4)
            {
                possibility &=~FILE_GH&NOT_WHITE_PIECES;
            }
            else {
                possibility &=~FILE_AB&NOT_WHITE_PIECES;
            }
            long j=possibility&~(possibility-1);
            while (j != 0)
            {
                int index=Long.numberOfTrailingZeros(j);
                list+=""+(iLocation/8)+(iLocation%8)+(index/8)+(index%8);
                possibility&=~j;
                j=possibility&~(possibility-1);
            }
            WN&=~i;
            i=WN&~(WN-1);
        }
        return list;
    }

    public static String possibleBW(long OCCUPIED, long WB){
        String list="";
        long i=WB&~(WB-1);
        long possibility;
        while(i != 0)
        {
            int iLocation=Long.numberOfTrailingZeros(i);
            possibility=DiagAndAntiDiagMoves(iLocation)&NOT_WHITE_PIECES;
            long j=possibility&~(possibility-1);
            while (j != 0)
            {
                int index=Long.numberOfTrailingZeros(j);
                list+=""+(iLocation/8)+(iLocation%8)+(index/8)+(index%8);
                possibility&=~j;
                j=possibility&~(possibility-1);
            }
            WB&=~i;
            i=WB&~(WB-1);
        }

        return list;
    }

    public static String possibleRW(long OCCUPIED, long WR){
        String list="";
        long i=WR&~(WR-1);
        long possibility;
        while(i != 0)
        {
            int iLocation=Long.numberOfTrailingZeros(i);
            possibility=HorizontalAndVerticalMoves(iLocation)&NOT_WHITE_PIECES;
            long j=possibility&~(possibility-1);
            while (j != 0)
            {
                int index=Long.numberOfTrailingZeros(j);
                list+=""+(iLocation/8)+(iLocation%8)+(index/8)+(index%8);
                possibility&=~j;
                j=possibility&~(possibility-1);
            }
            WR&=~i;
            i=WR&~(WR-1);
        }

        return list;
    }

    public static String possibleQW(long OCCUPIED, long WQ){
        String list="";
        long i=WQ&~(WQ-1);
        long possibility;
        //drawBitboard(HorizontalAndVerticalMoves(Long.numberOfTrailingZeros(i))&DiagAndAntiDiagMoves(Long.numberOfTrailingZeros(i))&NOT_WHITE_PIECES);
        while(i != 0)
        {
            int iLocation=Long.numberOfTrailingZeros(i);
            possibility=(HorizontalAndVerticalMoves(iLocation) | DiagAndAntiDiagMoves(iLocation))&NOT_WHITE_PIECES;
            long j=possibility&~(possibility-1);
            while (j != 0)
            {
                int index=Long.numberOfTrailingZeros(j);
                list+=""+(iLocation/8)+(iLocation%8)+(index/8)+(index%8);
                possibility&=~j;
                j=possibility&~(possibility-1);
            }
            WQ&=~i;
            i=WQ&~(WQ-1);
        }
        
        return list;
    }

    public static String possiblePW(String history, long WP, long BP){
        String list = "";
        //Capture Right

        //PawnMoves is the White Pawn bitboard, but shifted, and checked to meet certain parameters. 
        long PawnMoves=(WP>>7)& BLACK_PIECES& ~RANK_8& ~FILE_A;//capture right
        
        long possibility= PawnMoves&~(PawnMoves-1);

        //While loops snap to each piece in the bitboard.
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
        //TODO integrate while loop method into promotion logic.

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
    
        //En Passants
        if(history.length() >= 4 ){//ie: 6545

            boolean sameFile = history.charAt(history.length()-3) == history.charAt(history.length()-1);
            boolean movedUpTwo = Math.abs((history.charAt(history.length()-2) - '0') - (history.charAt(history.length()-4) - '0')) == 2;

            if(sameFile && movedUpTwo){

                int passantFile = history.charAt(history.length()-1) - '0';
                //en passant right
                possibility = (WP<<1)&BP&FileMasks8[passantFile]&~FILE_A;
                if(possibility != 0){
                    int index=Long.numberOfTrailingZeros(possibility);
                    list+=""+((index/8))+((index%8)-1)+(index/8-1)+(index%8);
                }


                //en passant left
                possibility = (WP>>1)&BP&FileMasks8[passantFile]&~FILE_H;
                System.out.println(possibility);
                if(possibility != 0){
                    int index=Long.numberOfTrailingZeros(possibility);
                    list+=""+((index/8))+((index%8)+1)+((index/8)-1)+(index%8);
                }

            }
        }

        return(list);
    }

    public static String possibleKW(long OCCUPIED, long WK){
    /*
     00000000
     00000000
     00000000
     00000000
     00000000
     00000111
     00000101
     00000111
     */
    String list="";
        long possibility;
        int iLocation=Long.numberOfTrailingZeros(WK);
        if (iLocation>9)
        {
            possibility=KING_RANGE<<(iLocation-9);
        }
        else {
            possibility=KING_RANGE>>(9-iLocation);
        }
        if (iLocation%8<4)
        {
            possibility &=~FILE_GH&NOT_WHITE_PIECES;
        }
        else {
            possibility &=~FILE_AB&NOT_WHITE_PIECES;
        }
        long j=possibility&~(possibility-1);
        while (j != 0)
        {
            int index=Long.numberOfTrailingZeros(j);
            list+=""+(iLocation/8)+(iLocation%8)+(index/8)+(index%8);
            possibility&=~j;
            j=possibility&~(possibility-1);
        }
        return list;
    }

    public static long unsafeForBlack(long WP,long WN,long WB,long WR,long WQ,long WK,long BP,long BN,long BB,long BR,long BQ,long BK)
    {
        long unsafe;
        OCCUPIED=WP|WN|WB|WR|WQ|WK|BP|BN|BB|BR|BQ|BK;
        //pawn
        unsafe=((WP>>>7)&~FILE_A);//pawn capture right
        unsafe|=((WP>>>9)&~FILE_H);//pawn capture left
        long possibility;
        //knight
        long i=WN&~(WN-1);
        while(i != 0)
        {
            int iLocation=Long.numberOfTrailingZeros(i);
            if (iLocation>18)
            {
                possibility=KNIGHT_RANGE<<(iLocation-18);
            }
            else {
                possibility=KNIGHT_RANGE>>(18-iLocation);
            }
            if (iLocation%8<4)
            {
                possibility &=~FILE_GH;
            }
            else {
                possibility &=~FILE_AB;
            }
            unsafe |= possibility;
            WN&=~i;
            i=WN&~(WN-1);
        }
        //bishop/queen
        long QB=WQ|WB;
        i=QB&~(QB-1);
        while(i != 0)
        {
            int iLocation=Long.numberOfTrailingZeros(i);
            possibility=DiagAndAntiDiagMoves(iLocation);
            unsafe |= possibility;
            QB&=~i;
            i=QB&~(QB-1);
        }
        //rook/queen
        long QR=WQ|WR;
        i=QR&~(QR-1);
        while(i != 0)
        {
            int iLocation=Long.numberOfTrailingZeros(i);
            possibility=HorizontalAndVerticalMoves(iLocation);
            unsafe |= possibility;
            QR&=~i;
            i=QR&~(QR-1);
        }
        //king
        int iLocation=Long.numberOfTrailingZeros(WK);
        if (iLocation>9)
        {
            possibility=KING_RANGE<<(iLocation-9);
        }
        else {
            possibility=KING_RANGE>>(9-iLocation);
        }
        if (iLocation%8<4)
        {
            possibility &=~FILE_GH;
        }
        else {
            possibility &=~FILE_AB;
        }
        unsafe |= possibility;
        System.out.println();
        drawBitboard(unsafe);
        return unsafe;
    }



    public static void drawBitboard(long bitBoard) {
        String chessBoard[][]=new String[8][8];
        for (int i=0;i<64;i++) {
            chessBoard[i/8][i%8]="";
        }
        for (int i=0;i<64;i++) {
            if (((bitBoard>>>i)&1)==1) {chessBoard[i/8][i%8]="P";}
            if ("".equals(chessBoard[i/8][i%8])) {chessBoard[i/8][i%8]=" ";}
        }
        for (int i=0;i<8;i++) {
            System.out.println(Arrays.toString(chessBoard[i]));
        }
    }


    /* 
    
    public static void timeExperiment(long WP) {
        int loopLength=1000;
        long startTime=System.currentTimeMillis();
        System.out.println(startTime);
        tEMethodA(loopLength, WP);
        long endTime=System.currentTimeMillis();
        System.out.println(endTime);
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