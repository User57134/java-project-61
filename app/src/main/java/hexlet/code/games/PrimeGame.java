package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.Question;
import java.security.SecureRandom;

public final class PrimeGame implements Game {
    private static final int DEFAULT_RADOM_MAX_VALUE = 100;
    private static final int SECOND_ODD_NUMBER = 3;
    private SecureRandom generator = null;
    private int upperLimit;

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
        for (int divisor = SECOND_ODD_NUMBER; divisor < limit; divisor += 2) {
            if (number % divisor == 0) {
                return false;
            }
        }

        return true;
    }

    public PrimeGame(int randomMaxValue) {
        upperLimit = randomMaxValue;
        generator = new SecureRandom();
    }

    public PrimeGame() {
        this(DEFAULT_RADOM_MAX_VALUE);
    }

    @Override
    public String getTask() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    public Question makeQuestion() {
        int number = generator.nextInt(upperLimit + 1);

        String answer = (isPrime(number)) ? "yes" : "no";

        return new Question(String.valueOf(number), answer);
    }
}
