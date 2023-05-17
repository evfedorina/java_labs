import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Main extends JFrame {
    JButton button;
    int x=40,y=40,w=250,h=250;
    Image img;
    Main(){
        super("Name");
        setLayout(null);
        img = new ImageIcon("pie.png").getImage();
        setDefaultCloseOperation(3);
        setSize(getToolkit().getScreenSize().width,getToolkit().getScreenSize().height);

        button = new JButton("+");
        button.setBounds(x,y,w,h);
        add(button);
        Timer timer = new Timer(17, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x+=1;
                repaint();
            }
        });
        timer.start();
        setVisible(true);
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawRect(x,y,250,250);
        Graphics2D g2 = (Graphics2D) g;
        AffineTransform at = g2.getTransform();
        g2.drawImage(img,x,y+100,w,h,null);
        at.rotate(Math.toRadians(90),x + w, y + h);
        g2.setTransform(at);
        g2.drawImage(img,x, y, w, h, null);
    }

    public static void main (String[]args){
        new Main();
    }
}