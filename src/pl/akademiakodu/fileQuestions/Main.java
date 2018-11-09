package pl.akademiakodu.fileQuestions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/*
In this packege we have Quiz with possibiliy to answer YES or NO. In this package you have List of Questions
defined in .txt type file. By using 'setQuestionProvider' from interfejs 'Question Provider' you can choose the file with questions.
To define if question is correct here we have class 'Question' and 'QuestionEnum'

The code is the same like in classQuestion packege. Here we use class FileQuestionProvider instead of  class with
List of question like 'MyQuestions()'
 */

public class Main extends JFrame implements ActionListener {

    private QuestionProvider questionProvider;
    private List<Question> questions;

    private JLabel label = new JLabel();
    private JButton yesButton;
    private JButton noButton;

    private int currentQuestion = 0;
    private int numberOfPoints = 0;


    // setter:)
    public void setQuestionProvider(QuestionProvider questionProvider) {
        this.questionProvider = questionProvider;
    }

    public Main() {

        //here we have special Class File Question Provider which is able to read a file
        setQuestionProvider(new FileQuestionProvider("questions.txt"));
        questions = questionProvider.getQuizQuestions();

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
            JOptionPane.showMessageDialog(null, "Game Over");
            yesButton.setEnabled(false);
            noButton.setEnabled(false);
        } else {
            setLabelTextQuestion();
        }
        JOptionPane.showMessageDialog(null, "Your Number of points is: " + numberOfPoints);
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
