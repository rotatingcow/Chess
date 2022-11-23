


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

        backBoard.changeBoardFen("2r2rk1/1p3pp1/4p2p/pB6/P1P3P1/3P4/3NK1P1/q6N b - - 1 25",true);

        frontBoard = new BoardPanel(backBoard.getBoard());
        gameFrame.add(frontBoard);
        gameFrame.pack();

        backBoard.resetBoard(true);
        System.out.println("\n\n\n");

        backBoard.changeBoardArray(frontBoard.getBoardPos(), true);

        gameFrame.setVisible(true);

    }

    
}
