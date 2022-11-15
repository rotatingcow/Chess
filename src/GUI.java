
import java.awt.*;
import java.io.File;

import javax.swing.*;
import javax.swing.event.*;

public class GUI extends JPanel implements MouseInputListener {
    int x=15 , y=15;
    
    public void paint(Graphics graphic){
        graphic.setColor(Color.BLUE);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        //System.out.println(new File("rook_white.png").getAbsolutePath());
        Image rookWhite = new ImageIcon(new File("rook_black.png").getAbsolutePath()).getImage();

        
        

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
        graphic.drawImage(rookWhite, x, y, this);
    }
    
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        
        
    }
    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        
    }
    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        x = e.getX();
        y= e.getY();
        repaint();
        
        
    }

}
