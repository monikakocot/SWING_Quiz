package pl.akademiakodu.classQuestions;

import java.util.List;

/*
We create an intersejs in which we say we need to have a method that will return the number of questions.
This information we can give to another programmer.
The person who will be responsible for providing us with the questions - this programmer,
can reate a class that implements the given interface.

 */

public interface QuestionProvider {
    List<Question> getQuizQuestions();
}
