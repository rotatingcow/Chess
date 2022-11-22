


import javax.swing.*;



import java.awt.*;

public class AlphaBetaChess {

    public static void main(String[] args) {
        JFrame gameFrame = new JFrame("Chess");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        gameFrame.setSize(800,800);
        gameFrame.setLayout(new BorderLayout());

        
       //GUI ui = new GUI();
       //gameFrame.add(ui);
       
        Board backBoard = new Board();
        BoardPanel frontBoard;

        backBoard.changeBoardFen("rn1qkb1r/1p3ppp/p2pbn2/4p3/4P3/1NN1BP2/PPP3PP/R2QKB1R b KQkq - 0 8",false);
        frontBoard = new BoardPanel(backBoard.getBoard());
        gameFrame.add(frontBoard);


        backBoard.resetBoard(true);

        System.out.println("\n\n\n\n");
        backBoard.changeBoardArray(frontBoard.getBoardPos(), true);
        backBoard.getStringBoard();



        gameFrame.setVisible(true);

    }

    
}
