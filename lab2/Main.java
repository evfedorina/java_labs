import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends JFrame{

    Main(){
        super("Menu");
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        setDefaultCloseOperation(3);
        setLayout(null);
        JButton gameButton = new JButton("START GAME");
        gameButton.setBounds(getWidth()/2-100, getHeight()/2-70, 200, 140);
        JPanel menuPanel = new JPanel();
        menuPanel.setBounds(0,0,getWidth(),getHeight());
        menuPanel.setLayout(null);
        add(menuPanel);
        menuPanel.add(gameButton);
        gameButton.addActionListener(new ActionListener() {
                boolean visible = true;
                @Override
                public void actionPerformed(ActionEvent e) {
                    visible = !visible;
                    menuPanel.setVisible(visible);
                    new Game();
                }
            });
        setVisible(true);
        // button.addActionListener(new Listener(button));
        // JButton button2 = new JButton("НАЖМИ КНОПКУ");
        // button2.setBounds(300, 400, 200, 140);
        // add(button2);
        // Listener listener = new Listener(button2);
        // Listener listener2 = new Listener(button);
        // button2.addActionListener(listener2);
        // button2.addActionListener(listener);
        // JTextArea textArea = new JTextArea();
        // textArea.setEditable(false);
        // textArea.setBounds(20, 100, 300, 150);
        // add(textArea);
        // textArea.setFont(new Font("Arial", 2, 20));
        // JTextField textField = new JTextField();
        // textField.setBounds(450, 125, 100, 100);
        // add(textField);
        // Chat chat = new Chat(textField, textArea);
        // textField.addActionListener(chat);

        // JButton gameButton = new JButton("Game");
        // gameButton.setBounds(0,0,200,25);
        // add(gameButton);
        // gameButton.addActionListener(new ActionListener() {
        //     boolean visible = true;
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         visible = !visible;
        //         gamePanel.setVisible(visible);
        //     }
        // });
        // JLabel label1 = new JLabel(new ImageIcon("wall.png"));
        // label1.setBounds(600, 50, 200, 40);
        // add(label1);
        // JButton runningButton = new JButton("Change Color");
        // runningButton.setBounds(800,30,120,40);
        // gamePanel.add(runningButton);
        // runningButton.addActionListener((new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         Random rng = new Random();
        //         runningButton.setForeground(new Color(rng.nextInt(256),rng.nextInt(256),rng.nextInt(256)));
        //         runningButton.setBackground(new Color(rng.nextInt(256),rng.nextInt(256),rng.nextInt(256)));
        //         runningButton.setOpaque(true);
        //         runningButton.setBorderPainted(false);
        //     }
        // }));
        // runningButton.addMouseListener((new MouseListener() {
        //     @Override
        //     public void mouseClicked(MouseEvent e) {
        //     }

        //     @Override
        //     public void mousePressed(MouseEvent e) {

        //     }

        //     @Override
        //     public void mouseReleased(MouseEvent e) {

        //     }

        //     @Override
        //     public void mouseEntered(MouseEvent e) {
        //        /// Random rng = new Random();
        //        /// int dx = rng.nextInt(-80,80);
        //       ///  int dy = rng.nextInt(-80,80);
        //       ///  runningButton.setLocation(runningButton.getX() + dx, runningButton.getY() + dy);
        //         int dx = runningButton.getWidth()/2-e.getX();
        //         int dy = runningButton.getHeight()/2-e.getY();
        //         int x = runningButton.getX() + dx;
        //         int y = runningButton.getY() + dy;
        //         if(x<0){
        //             x=0;
        //         }
        //         if(x + runningButton.getWidth() > gamePanel.getWidth()){
        //             x = x - runningButton.getWidth();
        //         }
        //         if(y<0){
        //             y=0;
        //         }
        //         if(y + runningButton.getHeight() > gamePanel.getHeight()){
        //             y = y - runningButton.getHeight();
        //         }
        //         runningButton.setLocation(x,y);
        //         if(runningButton.getBounds().intersects(button.getBounds())){
        //             button.setEnabled(false);
        //         }
        //         else
        //             button.setEnabled(true);
        //     }

        //     @Override
        //     public void mouseExited(MouseEvent e) {

        //     }
        // }));
    }
    public static void main(String[] args){
        new Main();
    }
}