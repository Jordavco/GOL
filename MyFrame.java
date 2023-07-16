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
    int length = 10;
    int size= length;
    JButton[] cells = new JButton[length*length+1];
    boolean[] liveCells = new boolean[length*length+1];
    MyFrame(){
        this.setTitle("JFrame title");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(new GridLayout(11,10,0,0));
        for(int i=1;i<length*length+1;i++){
            final int index = i;
            JButton button = new JButton(Integer.toString(i));
            button.setBackground(DEAD);
            button.setBorder(BorderFactory.createEmptyBorder(-5, -5, -5, -5));
            button.setOpaque(true);
            button.addActionListener(new ActionListener(){
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(button.getBackground().equals(ALIVE)){
                        button.setBackground(DEAD);
                        liveCells[index]=false;
                    }
                    else{
                        button.setBackground(ALIVE);
                        liveCells[index]=true;
                    }
                }
            });
            cells[i]=button;
            this.add(button);
        }
        JButton step = new JButton("Step");
        step.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                for(int i=1;i<cells.length;i++){
                    int neighbours = getNeighbourCount(i);
                    if(!liveCells[i] && neighbours==3){
                        cells[i].setBackground(ALIVE);
                    }
                    else if(liveCells[i] && (neighbours < 2 || neighbours > 3)){
                        cells[i].setBackground(DEAD);
                    }
                    
                }
                for(int i=1; i<cells.length;i++){
                    if(cells[i].getBackground().equals(ALIVE)){
                        liveCells[i]=true;
                    }
                    else{
                        liveCells[i]=false;
                    }
                }
            }
        });
        this.add(step);
        this.pack();
        this.setVisible(true);
    }

    public int getNeighbourCount(int cellIndex){
        int count=0;
        if(cellIndex>length){
            if(liveCells[cellIndex-length]){
                count++;
            }
            if(cellIndex%length != 1){
                if(liveCells[cellIndex-length-1]){
                    count++;
                }
            }
            if(cellIndex%length != 0){
                if(liveCells[cellIndex-length+1]){
                    count++;
                }
        }
            
        }
        if(cellIndex%length != 1){
            if(liveCells[cellIndex-1]){
                count++;
            }
        }
        if(cellIndex%length != 0){
            if(liveCells[cellIndex+1]){
                count++;
            }
        }
        if(cellIndex<(length*length)-length){
            if(liveCells[cellIndex+length]){
                count++;
            }
            if(cellIndex%length != 1){
                if(liveCells[cellIndex+length-1]){
                    count++;
                }
            }
            if(cellIndex%length != 0){
                if(liveCells[cellIndex+length+1]){
                    count++;
                }
        }
        }

        return count;
    }
}