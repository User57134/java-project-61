package hexlet.code.games;


import java.security.SecureRandom;
import hexlet.code.Engine;


public final class GcdGame {
    private static final int DEFAULT_RADOM_MAX_VALUE = 100;
    public static final int MAX_TRIES_NUMBER = 3;
    private SecureRandom generator = null;
    private int upperLimit;  // default value is 100
    private int tries;

    public GcdGame() {
        tries = MAX_TRIES_NUMBER;
        upperLimit = DEFAULT_RADOM_MAX_VALUE;
        generator = new SecureRandom();
    }

    private static int gcd(int a, int b) {
        while (a != b) {
            if (a == 0) {
                return b;
            }

            if (b == 0) {
                return a;
            }

            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }

        return a;
    }

    private String[][] makeQuestions() {
        String[][] questions = new String[tries][2];

        int num1 = 0;
        int num2 = 0;
        int result = 0;
        for (var i = 0; i < questions.length; i += 1) {
            num1 = generator.nextInt(upperLimit + 1);
            num2 = generator.nextInt(upperLimit + 1);
            result = gcd(num1, num2);
            questions[i][0] = num1 + " " + num2;
            questions[i][1] = String.valueOf(result);
        }

        return questions;
    }

    public void start() {
        String task = "Find the greatest common divisor of given numbers.";
        var questions = makeQuestions();

        if ((questions == null) || (questions.length == 0)
                || (questions.length > MAX_TRIES_NUMBER)) {
            System.out.println("The game was terminated due to a logical error.");
            return;
        }

        Engine.play(task, questions);
    }
}
