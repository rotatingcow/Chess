


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

        backBoard.changeBoardFen("2r2rkb/p4p1p/b1p3q1/4p1P1/P6Q/1B3P2/3PP3/BR3KR1 w G - 3 20",true);

        frontBoard = new BoardPanel(backBoard.getBoard());
        gameFrame.add(frontBoard);
        gameFrame.pack();

        backBoard.resetBoard(true);
        System.out.println("\n\n\n");

        backBoard.changeBoardArray(frontBoard.getBoardPos(), true);

        gameFrame.setVisible(true);

    }

    
}
