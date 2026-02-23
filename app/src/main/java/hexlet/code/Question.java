package hexlet.code;

public final class Question {
    private String text = "";
    private String answer = "";

    public Question(String qText, String qAnswer) {
        text = qText;
        answer = qAnswer;
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
