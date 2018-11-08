package pl.akademiakodu.classQuestions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Main extends JFrame implements ActionListener {

    /*
     We create a variable that is of the QuestionProvider type
     We do not say exactly what class it will be
     This class must implement the QuestionProvider interface
     */
    private QuestionProvider questionProvider;

    // questions to our program, which we collect using the questionsProvider object
    private List<Question> questions;

    private JLabel label = new JLabel();
    private JButton yesButton;
    private JButton noButton;

    private int currentQuestion = 0;
    private int numberOfPoints = 0;

   // private static final String YES_TEXT = "TAK"; now we have Enum
    //private static final String NO_TEXT = "NIE";  now we have Enum


    // setter:)
    public void setQuestionProvider(QuestionProvider questionProvider) {
        this.questionProvider = questionProvider;
    }

    public Main() {
        // here we choose the object/class with list of questions
        //the class must implement the QuestionProvider interface
        setQuestionProvider(new MyQuestions());

        questions = questionProvider.getQuizQuestions();
        // questions are collected using the questionProvider object

        setFrameDefualtProperties();
        addButtonsAndLabelToLayout();
    }

    private void setFrameDefualtProperties() {
        setTitle("Milionaires");
        setVisible(true);
        setSize(500, 500);
        setLayout(new GridLayout(3, 1));
    }

    private void addButtonsAndLabelToLayout() {
        setLabelTextQuestion();
        label.setHorizontalAlignment(JLabel.CENTER);
        yesButton = new JButton(QuestionEnum.YES.getName());
        yesButton.addActionListener(this);
        noButton = new JButton(QuestionEnum.NO.getName());
        noButton.addActionListener(this);
        add(label);
        add(yesButton);
        add(noButton);
    }

    private void setLabelTextQuestion() {
        label.setText(questions.get(currentQuestion).getContent()+"\n"+"Your Number of points is: "+numberOfPoints);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        if (jButton.getText().equals(QuestionEnum.YES.getName()) && questions.get(currentQuestion).isYesCorrect())
            numberOfPoints++;
        if (jButton.getText().equals(QuestionEnum.NO.getName()) && !questions.get(currentQuestion).isYesCorrect())
            numberOfPoints++;
        currentQuestion++;
        if (currentQuestion >= questions.size()) {
            JOptionPane.showMessageDialog(null, "GAME OVER");
            yesButton.setEnabled(false);
            noButton.setEnabled(false);
        } else {
            setLabelTextQuestion();
        }
        JOptionPane.showMessageDialog(null, "Your Number of points is " + numberOfPoints);
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