
import javax.swing.*;
import java.awt.*;


public class AlphaBetaChess {
    
    public static void main(String[] args) {
        JFrame gameFrame = new JFrame("Chess");
        
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GUI ui = new GUI();
        gameFrame.add(userInterface);
        gameFrame.setSize(750,750);
        gameFrame.setVisible(true);
       
    }
    
}
