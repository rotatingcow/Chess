


import javax.swing.*;




import java.awt.*;

public class AlphaBetaChess {

    public static void main(String[] args) {
        JFrame gameFrame = new JFrame("Chess");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        gameFrame.setSize(800,800);
        gameFrame.setResizable(false);
        gameFrame.setLayout(new BorderLayout());
       //GUI ui = new GUI();
       //gameFrame.add(ui);
        char[][] board = {

            {'r','n','b','q','k','b','n','r'},
            {'p','p','p','p','p','p','p','p'},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {'P','P','P','P','P','P','P','P'},
            {'R','N','B','Q','K','B','N','R'}

        };

        BoardPanel frontBoard;
        Board backBoard = new Board();
        
        //backBoard.changeBoardFen("k7/p2q4/3br3/8/8/8/5K2/8 w - - 0 1",false);
        backBoard.changeBoardArray(board, false);
        frontBoard = new BoardPanel(backBoard.getBoard());
        String possibleMoves = frontBoard.possibleMoves("1434", true, true);
        
        gameFrame.add(frontBoard);
        gameFrame.pack();
        gameFrame.setVisible(true);
     }
 
    
}
