package pl.akademiakodu.manualQuestions;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {


    public Main(){

        setFrameDefualtProperties();
        addButtonsAndLabelToLayout();
    }

    private void setFrameDefualtProperties(){
        setTitle("Milionairs");
        setVisible(true);
        setSize(500,500);
        setLayout(new GridLayout(3,1));
    }

    private void addButtonsAndLabelToLayout(){
        JLabel label = new JLabel("Is Poland in Europe?");

        label.setHorizontalAlignment(JLabel.CENTER);

        JButton yesButton = new JButton("YES");
        JButton noButton = new JButton("No");

        add(label);
        add(yesButton);
        add(noButton);

    }


    public static void main(String[] args) {

        // write your code here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });

    }
}