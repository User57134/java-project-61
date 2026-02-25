package hexlet.code.games;


import java.security.SecureRandom;
import hexlet.code.Engine;


public final class EvenGame {
    private static final int DEFAULT_RADOM_MAX_VALUE = 200;
    public static final int MAX_TRIES_NUMBER = 3;
    private SecureRandom generator = null;
    private int upperLimit;
    private int tries;

    public EvenGame() {
        tries = MAX_TRIES_NUMBER;
        upperLimit = DEFAULT_RADOM_MAX_VALUE;
        generator = new SecureRandom();
    }

    private String[][] makeQuestions() {
        String[][] questions = new String[3][2];

        int number = 0;
        for (var i = 0; i < questions.length; i += 1) {
            number = generator.nextInt(upperLimit + 1);
            questions[i][0] = String.valueOf(number);
            questions[i][1] = (number % 2 == 0) ? "yes" : "no";
        }

        return questions;
    }

    public void start() {
        String task = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        var questions = makeQuestions();

        if ((questions == null) || (questions.length == 0)
                || (questions.length > MAX_TRIES_NUMBER)) {
            System.out.println("The game was terminated due to a logical error.");
            return;
        }

        Engine.play(task, questions);
    }
}
