package pl.akademiakodu.fileQuestions;

import pl.akademiakodu.fileQuestions.Question;

import java.util.List;


// Tworzymy interfejs, w którym mówimy , że potrzebujemy mieć metodę
// która będzie nam zwraca liste pytań
// tą informację przekazujemy innemu programiśćie
/*
    osobie, która będzie odpowiedzialna za dostarczenie pytań
 */
// Programista tworzy Klasę, która implementuje dany interfejs

public interface QuestionProvider {
    List<Question> getQuizQuestions();
}
