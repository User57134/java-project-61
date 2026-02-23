package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.Question;
import java.security.SecureRandom;

public class ProgressionGame implements Game {
    private static final int PROGRESSION_MIN_LENGTH = 5;
    private static final int PROGRESSION_MAX_LENGTH = 10;

    private SecureRandom generator = null;
    private int randomMaxValue = 100;

    public ProgressionGame(int randomMaxValue) {
        this.randomMaxValue = randomMaxValue;
        generator = new SecureRandom();
    }

    public ProgressionGame() {
        this(100);
    }

    private int[] makeProgression() {
        int progressionLength = generator.nextInt(PROGRESSION_MIN_LENGTH, PROGRESSION_MAX_LENGTH + 1);
        int[] values = new int[progressionLength];

        int start = generator.nextInt(randomMaxValue + 1);
        values[0] = start;

        int step = generator.nextInt((randomMaxValue + 1) / 2);

        for (var i = 1; i < progressionLength; i += 1) {
            values[i] = start + i * step;
        }

        return values;
    }

    @Override
    public String getTask() {
        return "What number is missing in the progression?";
    }

    @Override
    public Question makeQuestion() {
        var values = makeProgression();

        int hiddenIndex = generator.nextInt(values.length);

        StringBuilder builder = new StringBuilder();
        for (var i = 0; i < values.length; i += 1) {
            if (i != hiddenIndex) {
                builder.append(values[i]);
            } else {
                builder.append("..");
            }

            if (i != values.length - 1) {
                builder.append(" ");
            }
        }

        return new Question(builder.toString(), String.valueOf(values[hiddenIndex]));
    }
}
