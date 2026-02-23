package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.Question;
import java.security.SecureRandom;

public class PrimeGame implements Game {
    private SecureRandom generator = null;
    private int randomMaxValue = 100;

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
        for (int divisor = 3; divisor < limit; divisor += 2) {
            if (number % divisor == 0) {
                return false;
            }
        }

        return true;
    }

    public PrimeGame(int randomMaxValue) {
        this.randomMaxValue = randomMaxValue;
        generator = new SecureRandom();
    }

    public PrimeGame() {
        this(100);
    }

    @Override
    public String getTask() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    public Question makeQuestion() {
        int number = generator.nextInt(randomMaxValue + 1);

        String answer = (isPrime(number)) ? "yes" : "no";

        return new Question(String.valueOf(number), answer);
    }
}
