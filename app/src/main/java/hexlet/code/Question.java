package hexlet.code;

public class Question {
    private String text = "";
    private String answer = "";

    public Question(String text, String answer) {
        this.text = text;
        this.answer = answer;
    }

    String getText() {
        return text;
    }

    String getAnswer() {
        return answer;
    }

    boolean check(String customAnswer) {
        return customAnswer.equals(answer);
    }
}
