

import javax.swing.*;

//import java.awt.*;

public class AlphaBetaChess {

    public static void main(String[] args) {
        JFrame gameFrame = new JFrame("Chess");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        gameFrame.setSize(750,750);

        
        GUI ui = new GUI();
        gameFrame.add(ui);
        gameFrame.setVisible(true);

        Board m_board = new Board();
        boolean repeat = true;
        if(repeat){
            m_board.resetBoard();
            System.out.println("og board\n" + m_board.getBoard());
            m_board.changeBoard("rnb1k1rn/p1p3pp/1p6/4p3/4P3/6P1/PPPP2K1/RNBB4 b ga e3 0 10");
            System.out.println("new board\n" + m_board.getBoard());
            repeat = false;
        }
 
    }
    
}
