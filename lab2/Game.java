import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class Game extends JFrame{
    void endGame(){
        setVisible(false);
    }

    Game(){
        super("Game");
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        setDefaultCloseOperation(3);
        setLayout(null);
        JButton button = new JButton("1000");
        JLabel label = new JLabel(new ImageIcon("1.png"));
        Controller controller = new Controller(label);
        button.addKeyListener(controller);
        label.setBounds((getWidth()-367)/2, (getHeight()-500)/2, 367, 500);
        Random rng = new Random();
        button.setBounds(0, 0, 200, 140);
        add(label);
        add(button);
        button.setBackground(new Color(rng.nextInt(150)+50, rng.nextInt(150)+50, rng.nextInt(150)+50));
        Timer timer = new Timer(10, new ActionListener() {
                int health = 1000;
                int score = 0;
                @Override
                public void actionPerformed(ActionEvent e) {
                    Random rng = new Random();
                    int dx = rng.nextInt(121) - 60;
                    int dy = rng.nextInt(121) - 60;
                    label.setLocation(label.getX() + dx,label.getY() + dy);
                    getContentPane().setBackground(new Color(rng.nextInt(150)+50, rng.nextInt(150)+50, rng.nextInt(150)+50));
                    if(label.getX()<0 || label.getY()<0 || label.getX()+367>getWidth() || label.getY()+500>getHeight()) health = health - 1;
                    button.setText(Integer.toString(health));
                    if(health<0) endGame();
                }
            });
        timer.start();
        setVisible(true);
    }
}
