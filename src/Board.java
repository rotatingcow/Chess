import java.util.Arrays;

public class Board {


    public long WP = 0L, BP = 0L, WN = 0L, BN = 0L, WR = 0L, BR = 0L, WQ = 0L, BQ = 0L, WB = 0L, BB = 0L, WK = 0L, BK = 0L;

    public Board(){
    
    }


    public char[][] board = {
        {'r','n','b','q','k','b','n','r'},
        {'p','p','p','p','p','p','p','p'},
        {' ',' ',' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' ',' ',' '},
        {'P','P','P','P','P','P','P','P'},
        {'R','N','B','Q','K','B','N','R'}
    };



    public void drawArray(long WP, long WN, long WB, long WQ, long WK, long WR, long BP, long BN, long BB, long BQ, long BK, long BR){
        String newChessBoard[][] = new String[8][8];

        for(int i = 0; i<64; i++){
            newChessBoard[i/8][i%8] = " ";
        }
        for(int i = 0; i < 64; i++){
            if( ((this.WP>>i)&1) == 1)  {newChessBoard[i/8][i%8] = "P";}
            if( ((this.WR>>i)&1) == 1)  {newChessBoard[i/8][i%8] = "R";}
            if( ((this.WN>>i)&1) == 1)  {newChessBoard[i/8][i%8] = "N";}
            if( ((this.WB>>i)&1) == 1)  {newChessBoard[i/8][i%8] = "B";}
            if( ((this.WQ>>i)&1) == 1)  {newChessBoard[i/8][i%8] = "Q";}
            if( ((this.WK>>i)&1) == 1)  {newChessBoard[i/8][i%8] = "K";}
            if( ((this.BP>>i)&1) == 1)  {newChessBoard[i/8][i%8] = "p";}
            if( ((this.BR>>i)&1) == 1)  {newChessBoard[i/8][i%8] = "r";}
            if( ((this.BN>>i)&1) == 1)  {newChessBoard[i/8][i%8] = "n";}
            if( ((this.BB>>i)&1) == 1)  {newChessBoard[i/8][i%8] = "b";}
            if( ((this.BQ>>i)&1) == 1)  {newChessBoard[i/8][i%8] = "q";}
            if( ((this.BK>>i)&1) == 1)  {newChessBoard[i/8][i%8] = "k";}
        }
        for(int i = 0; i< 8; i++){
            System.out.println(Arrays.toString(newChessBoard[i]));
        }
    }
//, long WP, long WN, long WB, long WQ, long WK, long WR, long BP, long BN, long BB, long BQ, long BK, long BR

    public void arrayToBitBoard(boolean draw,char[][] chessboard){
        String binary;
        
        for(int i = 0; i<64; i++){
            binary = "0000000000000000000000000000000000000000000000000000000000000000";
            binary = binary.substring(i,i+1)+"1"+binary.substring(0,i);
            switch(chessboard[i/8][i%8]){
                case 'P': WP += stringToBitboard(binary);
                    break;
                case 'R': WR += stringToBitboard(binary);
                    break; 
                case 'N': WN += stringToBitboard(binary);
                    break;  
                case 'B': WB += stringToBitboard(binary);
                    break;   
                case 'Q': WQ += stringToBitboard(binary);
                    break; 
                case 'K': WK += stringToBitboard(binary);
                    break; 
                case 'p': BP += stringToBitboard(binary);
                    break;
                case 'r': BR += stringToBitboard(binary);
                    break; 
                case 'n': BN += stringToBitboard(binary);
                    break;  
                case 'b': BB += stringToBitboard(binary);
                    break;   
                case 'q': BQ += stringToBitboard(binary);
                    break; 
                case 'k': BK += stringToBitboard(binary);
                    break;
            }

        }
    }

    public static long stringToBitboard(String binary){
        if(binary.charAt(0) == '0'){
            try{
                return Long.parseLong(binary, 2);
            }catch(Exception e){
                return Long.parseLong("-"+binary, 2);
            }
            
        }
        else{
            return Long.parseLong("1"+binary.substring(2),2)*2;
        }

    }
    

    public String getStringBoard(){
        String row1 = Arrays.toString(board[0]);
        String row2 = Arrays.toString(board[1]);
        String row3 = Arrays.toString(board[2]);
        String row4 = Arrays.toString(board[3]);
        String row6 = Arrays.toString(board[4]);
        String row7 = Arrays.toString(board[5]);
        String row8 = Arrays.toString(board[6]);
        String row9 = Arrays.toString(board[7]);

        return("{"+row1+"\n"+row2+"\n"+row3+"\n"+row4+"\n"+row6+"\n"+row7+"\n"+row8+"\n"+row9+"\n"+" }");
    }

    public char[][] getBoard(){
        return board;
    }
    
   
    public void changeBoard(String fen,boolean draw){
        char[][] newBoard = {
            {'r','n','b','q','k','b','n','r'},
            {'p','p','p','p','p','p','p','p'},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {'P','P','P','P','P','P','P','P'},
            {'R','N','B','Q','K','B','N','R'}
        };
        int index = 0;
        int row = 0;
        for(int i = 0; i < fen.length(); i++){
            char fenAt = fen.charAt(i);
            
            int num = fenAt - '0';
            //System.out.println("fenChar = " + fenAt+"| " + (num<9)+ "| "+row +" "+index);
            if(row == 7){
                if(index == 7){
                    break;
                }
            }
            if(fenAt == '/'){
                row++;
                index = 0;
            }
            else if(num < 9){
                for(int s = 0; s < num; s++){
                    newBoard[row][index] = ' ';
                    index++;
                    if(row == 7){ 
                        if(index == 7){
                            break;
                        }
                    }
    
                }
            } 
            else{
                newBoard[row][index] = fenAt;
                index++;
            }
        }
        for(int i = 0; i < 8; i++){
            for(int s = 0; s < 8; s++){
                //System.out.println("old board = "+ board[i][s] + "| new board = "+ newBoard[i][s]);
                board[i][s] = newBoard[i][s];
            }
        }
        if(draw){
            arrayToBitBoard(true,board);
        }
        else{
            arrayToBitBoard(false,board);
        }
       
        drawArray(WP, WN, WB, WQ, WK, WR, BP, BN, BB, BQ, BK, BR);
            
    }

    public void drawBitBoards(){
        System.out.println(WP+"\n"+WR+"\n"+WN+"\n"+WB+"\n"+WQ+"\n"+WK+"\n"+BN+"\n"+BR+"\n"+BB+"\n"+BQ+"\n"+BK+"\n"+BP+"\n");

    }

    public void resetBoard(boolean draw){
        char[][] startingBoard = {
        {'r','n','b','q','k','b','n','r'},
        {'p','p','p','p','p','p','p','p'},
        {' ',' ',' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' ',' ',' '},
        {'P','P','P','P','P','P','P','P'},
        {'R','N','B','Q','K','B','N','R'}
        };

        for(int i = 0; i < 8; i++){
            for(int s = 0; s < 8; s++){
                board[i][s] = startingBoard[i][s];
            }
        }

        arrayToBitBoard(true,board);
        drawArray(WP, WN, WB, WQ, WK, WR, BP, BN, BB, BQ, BK, BR);
    }
    






    public void addPiece(int col, int rank, Piece piece){

    }
    
}
