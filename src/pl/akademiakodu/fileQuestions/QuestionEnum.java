package pl.akademiakodu.fileQuestions;


public enum QuestionEnum {
    YES("TAK",true),
    NO("NIE",false),
    SI("TAK",true),
    NEIN("NIE",false);

    private String name;
    private boolean isCorrect;

    // GETTERS,SETTERS, TO STRING

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

    QuestionEnum(String name, boolean isCorrect) {
        this.name = name;
        this.isCorrect = isCorrect;
    }
}
