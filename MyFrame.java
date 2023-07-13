import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;



public class MyFrame extends JFrame{
    Color ALIVE = Color.YELLOW;
    Color DEAD =Color.BLACK;
    MyFrame(){
        this.setTitle("JFrame title");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(new GridLayout(10,10,0,0));
        for(int i=1;i<101;i++){
            JButton button = new JButton(Integer.toString(i));
            button.setBackground(ALIVE);
            button.setBorder(BorderFactory.createEmptyBorder(-5, -5, -5, -5));
            button.setOpaque(true);
            button.addActionListener(new ActionListener(){
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(button.getBackground().equals(ALIVE)){
                        button.setBackground(DEAD);
                    }
                    else{
                        button.setBackground(ALIVE);
                    }
                }
            });
            this.add(button);
        }
        this.pack();
        this.setVisible(true);
    }
}