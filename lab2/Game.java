import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Game extends JFrame{
    private Main main;
    void endGame(int score){
        JTextArea rip = new JTextArea();
        rip.setFont(new Font("Arial", 2, 60));
        rip.setBounds((getWidth()-600)/2, (getHeight()-700)/2, 600, 300);
        rip.setText("YOU DIED, BRO. \nYOUR SCORE: " + Integer.toString(score));
        rip.setBackground(new Color(0, 0, 0, 0));
        add(rip);
        JButton toMenu = new JButton("BACK TO MENU");
        toMenu.setBounds((getWidth()-600)/2, (getHeight()-100)/2, 600, 100);
        toMenu.setBackground(new Color(0, 0, 0, 0));
        toMenu.setFont(new Font("Arial", 2, 60));
        add(toMenu);
        toMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.stopGameMusic();
                setVisible(false);
                main.playMenuMusic();
            }
        });
    }

    Game(Main main, int dHealth, int dDist){
        super("Game");
        this.main = main;
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        setDefaultCloseOperation(3);
        setLayout(null);
        JButton hButton = new JButton("");
        JTextArea mes = new JTextArea();
        mes.setFont(new Font("Arial", 2, 30));
        JLabel label = new JLabel(new ImageIcon("1.png"));
        Controller controller = new Controller(label);
        hButton.addKeyListener(controller);
        label.setBounds((getWidth()-367)/2, (getHeight()-500)/2, 367, 500);
        Random rng = new Random();
        mes.setBounds(10, 10, 300, 140);
        add(label);
        add(hButton);
        add(mes);
        mes.setBackground(new Color(rng.nextInt(150)+50, rng.nextInt(150)+50, rng.nextInt(150)+50, 0));
        Timer timer = new Timer(10, new ActionListener() {
            int health = dHealth;
            int score = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(health>0){
                    Random rng = new Random();
                    int dx = rng.nextInt(dDist) - dDist/2;
                    int dy = rng.nextInt(dDist) - dDist/2;
                    label.setLocation(label.getX() + dx,label.getY() + dy);
                    getContentPane().setBackground(new Color(rng.nextInt(150)+50, rng.nextInt(150)+50, rng.nextInt(150)+50));
                    if(label.getX()<0 || label.getY()<0 || label.getX()+367>getWidth() || label.getY()+500>getHeight()) health--;
                    else score++;
                    mes.setText("Health: " + Integer.toString(health) + "\n Score: " + Integer.toString(score));
                    if(health==0) {endGame(score);}}
            }
        });
        timer.start();
        setVisible(true);
    }
}