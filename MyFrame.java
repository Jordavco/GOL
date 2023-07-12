import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
    MyFrame(){
        this.setTitle("JFrame title");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(new GridLayout(10,10,0,0));
        for(int i=1;i<101;i++){
            JButton button = new JButton(Integer.toString(i));
            button.setBackground(Color.YELLOW);
            button.setBorder(BorderFactory.createEmptyBorder(-5, -5, -5, -5));
            button.setOpaque(true);
            this.add(button);
        }
        this.pack();
        this.setVisible(true);
    }
}