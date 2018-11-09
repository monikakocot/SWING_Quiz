package pl.akademiakodu.manualQuestions;

import pl.akademiakodu.classQuestions.QuestionEnum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Quiz with possibiliy to answer YES or NO. In this package you have only 1 question then you put manualy before game.
 */
public class Main extends JFrame implements ActionListener {

    private int numberOfPoints = 0;
    private JLabel labelPoints = new JLabel();

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
        yesButton.addActionListener(this);
        JButton noButton = new JButton("NO");
        noButton.addActionListener(this);


        add(label);
        add(yesButton);
        add(noButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        if (jButton.getText().equals("YES")) {
            numberOfPoints++;
            JOptionPane.showMessageDialog(null, "You WIN! Your Number of points is: " + numberOfPoints);
        } else {
            JOptionPane.showMessageDialog(null, "Your Number of points is: " + numberOfPoints);
        }
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