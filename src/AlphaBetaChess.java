import javax.swing.*;
import java.awt.*;

public class AlphaBetaChess {

    public static void main(String[] args) {
        JFrame gameFrame = new JFrame("Chess");
        
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GUI ui = new GUI();
        ui.paintComponents(null);
        gameFrame.add(ui);
        gameFrame.setSize(750,750);
        gameFrame.setVisible(true);
       
    }
    
}
