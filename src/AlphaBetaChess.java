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
    }
    
}
