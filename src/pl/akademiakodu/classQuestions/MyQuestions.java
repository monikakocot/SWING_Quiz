package pl.akademiakodu.classQuestions;

import java.util.ArrayList;
import java.util.List;

public class MyQuestions implements QuestionProvider {

    @Override
    public List<Question> getQuizQuestions() {
        List<Question> questions = new ArrayList<Question>();
        questions.add(new Question("Is London the biggest town ine the World?",false));
        questions.add(new Question("Is sky blue?",true));
        questions.add(new Question("Is Quieto the capital of Ecuador?",true));
        questions.add(new Question("Are you hungry?",false));
        questions.add(new Question("Is apple a fruit?",true));
        return questions;
    }
}

