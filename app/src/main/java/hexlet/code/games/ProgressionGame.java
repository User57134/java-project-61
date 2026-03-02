package hexlet.code.games;


import java.security.SecureRandom;
import hexlet.code.Engine;


public final class ProgressionGame {
    private static final int DEFAULT_RADOM_MAX_VALUE = 100;
    private static final int PROGRESSION_MIN_LENGTH = 5;
    private static final int PROGRESSION_MAX_LENGTH = 10;
    private SecureRandom generator = null;
    private int upperLimit;  // default value is 100

    public ProgressionGame() {
        upperLimit = DEFAULT_RADOM_MAX_VALUE;
        generator = new SecureRandom();
    }

    private String[] makeProgression(int start, int step, int length) {
        String[] values = new String[length];
        values[0] = String.valueOf(start);

        for (var i = 1; i < length; i += 1) {
            values[i] = String.valueOf(start + i * step);
        }

        return values;
    }

    private String[][] makeQuestions() {
        String[][] questions = new String[Engine.ROUNDS][2];

        int hiddenIndex = 0;
        int start = 0;
        int step = 0;
        int length = 0;
        for (var i = 0; i < questions.length; i += 1) {
            start = generator.nextInt(upperLimit + 1);
            step = generator.nextInt((upperLimit + 1) / 2);
            length = generator.nextInt(PROGRESSION_MIN_LENGTH, PROGRESSION_MAX_LENGTH + 1);
            var values = makeProgression(start, step, length);
            hiddenIndex = generator.nextInt(values.length);

            questions[i][1] = values[hiddenIndex];
            values[hiddenIndex] = "..";

            questions[i][0] = String.join(" ", values);
        }

        return questions;
    }

    public void start() {
        String task = "What number is missing in the progression?";
        var questions = makeQuestions();

        if ((questions == null) || (questions.length == 0)
                || (questions.length > Engine.ROUNDS)) {
            System.out.println("The game was terminated due to a logical error.");
            return;
        }

        Engine.play(task, questions);
    }
}

