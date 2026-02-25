package hexlet.code.games;


import java.security.SecureRandom;
import hexlet.code.Engine;


public final class PrimeGame {
    private static final int DEFAULT_RADOM_MAX_VALUE = 100;
    public static final int MAX_TRIES_NUMBER = 3;
    private SecureRandom generator = null;
    private int upperLimit;  // default value is 100
    private int tries;

    public PrimeGame() {
        tries = MAX_TRIES_NUMBER;
        upperLimit = DEFAULT_RADOM_MAX_VALUE;
        generator = new SecureRandom();
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        if (number % 2 == 0) {
            return false;
        }

        int limit = (int) Math.sqrt(number) + 1;
        int secondOddNumber = 3;
        for (int divisor = secondOddNumber; divisor < limit; divisor += 2) {
            if (number % divisor == 0) {
                return false;
            }
        }

        return true;
    }

    private String[][] makeQuestions() {
        String[][] questions = new String[tries][2];

        int number = 0;
        for (var i = 0; i < questions.length; i += 1) {
            number = generator.nextInt(upperLimit + 1);
            questions[i][0] = String.valueOf(number);
            questions[i][1] = (isPrime(number)) ? "yes" : "no";
        }

        return questions;
    }

    public void start() {
        String task = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        var questions = makeQuestions();

        if ((questions == null) || (questions.length == 0)
                || (questions.length > MAX_TRIES_NUMBER)) {
            System.out.println("The game was terminated due to a logical error.");
            return;
        }

        Engine.play(task, questions);
    }
}
