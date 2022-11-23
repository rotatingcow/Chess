
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class GUI extends JPanel implements MouseInputListener {
    int x=15 , y=15;
    
    public void paint(Graphics graphic){
        graphic.setColor(Color.BLUE);

        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        for(int c = 1; c< 9; c++){
            for(int r = 1; r < 9; r++){
                if((r+c) % 2 == 0){
                    graphic.setColor(new Color(255,248,238));
                }
                else{
                    graphic.setColor(new Color(102, 61, 20));
                }
                graphic.fillRect(r*50+150, c*50+150, 50, 50);
            }
        }
    }


    
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y= e.getY();
        repaint();
        
        
    }

}
