import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Chat implements ActionListener{
    JTextField Input;
    JTextArea Output;
    Chat(JTextField input, JTextArea output){
        this.Input = input;
        this.Output = output;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Output.setText(Output.getText() + "\n" + Input.getText());
        Input.setText("");
    }

}
