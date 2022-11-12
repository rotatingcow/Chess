
import java.awt.*; 
import javax.swing.*;
public class GUI extends JPanel{

    public void paintComponents(Graphics graphic){
        graphic.setColor(Color.RED);
        graphic.fillRect(20, 10, 20, 10);
    }
    

}
