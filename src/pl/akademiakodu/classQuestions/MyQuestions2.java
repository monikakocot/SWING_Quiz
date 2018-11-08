package pl.akademiakodu.classQuestions;

import java.util.ArrayList;
import java.util.List;

public class MyQuestions2 implements QuestionProvider {

    @Override
    public List<Question> getQuizQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Is it love?", true));
        questions.add(new Question("Is winter in Poland cold?", true));
        questions.add(new Question("Is pizza tradicional Italian dish?", true));
        questions.add(new Question("Are you gonna be my girl?", true));
        questions.add(new Question("Is ....?", false));

        return questions;
    }
}
