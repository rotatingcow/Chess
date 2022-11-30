


import javax.swing.*;




import java.awt.*;
import java.util.ArrayList;

public class AlphaBetaChess {

    public static void main(String[] args) {
        
           

        JFrame gameFrame = new JFrame("Chess");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        gameFrame.setSize(800,800);
        gameFrame.setResizable(false);
        gameFrame.setLayout(new BorderLayout());

       //GUI ui = new GUI();
       //gameFrame.add(ui);
       
        Board backBoard = new Board();
        BoardPanel frontBoard;
        backBoard.changeBoardFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1",false);
        frontBoard = new BoardPanel(backBoard.getBoard());
        String possiblePawnMoves = backBoard.getPossibleMovesWhite("1434", false);
        System.out.println(possiblePawnMoves);


        gameFrame.add(frontBoard);
        gameFrame.pack();
        gameFrame.setVisible(true);

    }

    
}
