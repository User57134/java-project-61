package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.Question;
import java.security.SecureRandom;

public class GcdGame implements Game {
    private int randomMaxValue = 1000;
    private SecureRandom generator = null;

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

    public GcdGame(int randomMaxValue) {
        this.randomMaxValue = randomMaxValue;
        generator = new SecureRandom();
    }

    public GcdGame() {
        this(1000);
    }

    @Override
    public String getTask() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public Question makeQuestion() {
        int num1 = generator.nextInt(randomMaxValue + 1);
        int num2 = generator.nextInt(randomMaxValue + 1);
        int result = gcd(num1, num2);

        return new Question(num1 + " " + num2, String.valueOf(result));
    }
}
