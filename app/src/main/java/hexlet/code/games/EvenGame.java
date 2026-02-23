package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.Question;
import java.security.SecureRandom;


public final class EvenGame implements Game {
    private static final int DEFAULT_RADOM_MAX_VALUE = 100;
    private SecureRandom generator = null;
    private int upperLimit;  // default value is 100

    public EvenGame(int randomMaxValue) {
        upperLimit = randomMaxValue;
        generator = new SecureRandom();
    }

    public EvenGame() {
        this(DEFAULT_RADOM_MAX_VALUE);
    }

    @Override
    public String getTask() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public Question makeQuestion() {
        int number = generator.nextInt(upperLimit + 1);  // Random from 0 to defaultRandomRangeMax
        String answer = (number % 2 == 0) ? "yes" : "no";

        return new Question(String.valueOf(number), answer);
    }
}
