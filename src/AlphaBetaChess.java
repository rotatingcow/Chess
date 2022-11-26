


import javax.swing.*;



import java.awt.*;

public class AlphaBetaChess {

    public static void main(String[] args) {

        //org.openjdk.jmh.Main.main(args);
        JFrame gameFrame = new JFrame("Chess");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        gameFrame.setSize(800,800);
        gameFrame.setLayout(new BorderLayout());


       //GUI ui = new GUI();
       //gameFrame.add(ui);
       
        Board backBoard = new Board();
        BoardPanel frontBoard;
        backBoard.changeBoardFen("8/8/8/4pP2/8/8/1P6/8 w - - 0 1",false);
        frontBoard = new BoardPanel(backBoard.getBoard());


        String possiblePawnMoves = backBoard.getPossibleMovesWhite("1434", true);
        System.out.println(possiblePawnMoves);


        gameFrame.add(frontBoard);
        gameFrame.pack();
        gameFrame.setVisible(true);

    }

    
}
