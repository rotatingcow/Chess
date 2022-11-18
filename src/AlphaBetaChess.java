
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
            m_board.resetBoard(true);
            m_board.changeBoard("n2rnrk1/ppb1p1pp/2p2p2/8/5P2/5QPq/PP1PPK1P/NB1R2BR w - - 1 10",false);
            System.out.println(m_board.WP);
        }
 
    }
}
