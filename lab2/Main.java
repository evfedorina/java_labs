import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends JFrame{
    Main(){
        super("App");
        setSize(1280, 720);
        setDefaultCloseOperation(3);
        setLayout(null);
        JButton button = new JButton("НАЖМИ КНОПКУ");
        button.setBounds(20, 20, 200, 140);
        add(button);
        button.addActionListener(new Listener(button));
        JButton button2 = new JButton("НАЖМИ КНОПКУ");
        button2.setBounds(100, 500, 200, 140);
        add(button2);
        Listener listener = new Listener(button2);
        Listener listener2 = new Listener(button);
        button2.addActionListener(listener2);
        button2.addActionListener(listener);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(20, 100, 300, 150);
        add(textArea);
        textArea.setFont(new Font("Arial", 2, 20));
        JTextField textField = new JTextField();
        textField.setBounds(500, 500, 100, 100);
        add(textField);
        Chat chat = new Chat(textField, textArea);
        textField.addActionListener(chat);
        JLabel label = new JLabel(new ImageIcon("1.jpeg"));
        Controller controller = new Controller(label);
        button.addKeyListener(controller);
        label.setBounds(400, 400, 200, 200);
        add(label); 
        setVisible(true);
    }
    public static void main(String[] args){
        new Main();
    }
}