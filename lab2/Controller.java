import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Controller implements KeyListener{
    JLabel label;
    Controller(JLabel label){
        this.label = label;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                label.setLocation(label.getX(), label.getY()-100);
                break;
            case KeyEvent.VK_D:
                label.setLocation(label.getX()+100, label.getY());
                break;
            case KeyEvent.VK_A:
                label.setLocation(label.getX()-100, label.getY());
                break;
            case KeyEvent.VK_S:
                label.setLocation(label.getX(), label.getY()+100);
                break;
        }
    }
}
