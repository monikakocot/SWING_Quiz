package pl.akademiakodu.fileQuestions;

public class Question {

    private String content;
    private boolean isYesCorrect;

    public Question(String content) {
        this.content = content;
    }

    public Question(String content, boolean isYesCorrect) {
        this.content = content;
        this.isYesCorrect = isYesCorrect;
    }

    // GETTERS,SETTERS, TO STRING

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isYesCorrect() {
        return isYesCorrect;
    }

    public void setYesCorrect(boolean yesCorrect) {
        isYesCorrect = yesCorrect;
    }

    @Override
    public String toString() {
        return "Question{" +
                "content='" + content + '\'' +
                ", isYesCorrect=" + isYesCorrect +
                '}';
    }
}
