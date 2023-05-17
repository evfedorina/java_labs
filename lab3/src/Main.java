import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Main extends JFrame {
    JButton button;
    int x=40,y=40,w=40,h=40;
    Main(){
        super("Name");
        setLayout(null);
        setDefaultCloseOperation(3);
        setSize(getToolkit().getScreenSize().width,getToolkit().getScreenSize().height);

        button = new JButton("+");
        button.setBounds(x,y,w,h);
        add(button);
        Timer timer = new Timer(7, new ActionListener() {
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
        g.drawRect(x,y,40,40);
    }

    public static void main (String[]args){
        new Main();
    }
}