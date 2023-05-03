import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

class Listener implements ActionListener{
    int i = 0;
    JButton button;
    Listener (JButton button){
        this.button = button;
    }
    @Override
    public void actionPerformed(ActionEvent a){
        i++;
        button.setText("Clicked " + i + " times");
    }
}
