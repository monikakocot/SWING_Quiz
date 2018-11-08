package pl.akademiakodu.classQuestions;

public enum QuestionEnum {

    YES("TAK",true),
    NO("NIE",false);

    private String name;

    private boolean isCorrect;

    QuestionEnum(String name, boolean isCorrect) {

        this.name = name;
        this.isCorrect = isCorrect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}