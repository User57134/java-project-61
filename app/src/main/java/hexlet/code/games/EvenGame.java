package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.Question;
import java.security.SecureRandom;


public class EvenGame implements Game {
    private SecureRandom generator = null;

    private int randomMaxValue = 100;  // default value is 100

    public EvenGame(int randomMaxValue) {
        this.randomMaxValue = randomMaxValue;
        generator = new SecureRandom();
    }

    public EvenGame() {
        this(100);
    }

    @Override
    public String getTask() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public Question makeQuestion() {
        int number = generator.nextInt(randomMaxValue + 1);  // Random from 0 to defaultRandomRangeMax
        String answer = (number % 2 == 0) ? "yes" : "no";

        return new Question(String.valueOf(number), answer);
    }
}
