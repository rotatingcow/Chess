import java.util.Arrays;

public class Board {

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
    

    public String getBoard(){
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
    


    public void changeBoard(String fen){
        char[][] newBoard = {
            {'r','n','b','q','k','o','n','r'},
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
            System.out.println("fenChar = " + fenAt+"| " + (num<9)+ "| "+row +" "+index);
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
                System.out.println("old board = "+ board[i][s] + "| new board = "+ newBoard[i][s]);
                board[i][s] = newBoard[i][s];
            }
        }
            
    }
    public void resetBoard(){
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
    }






    public void addPiece(int col, int rank, Piece piece){

    }
    
}

