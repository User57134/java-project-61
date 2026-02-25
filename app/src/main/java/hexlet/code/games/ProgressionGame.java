package hexlet.code.games;


import java.security.SecureRandom;
import hexlet.code.Engine;


public final class ProgressionGame {
    private static final int DEFAULT_RADOM_MAX_VALUE = 100;
    public static final int MAX_TRIES_NUMBER = 3;
    private static final int PROGRESSION_MIN_LENGTH = 5;
    private static final int PROGRESSION_MAX_LENGTH = 10;
    private SecureRandom generator = null;
    private int upperLimit;  // default value is 100
    private int tries;

    public ProgressionGame() {
        tries = MAX_TRIES_NUMBER;
        upperLimit = DEFAULT_RADOM_MAX_VALUE;
        generator = new SecureRandom();
    }

    private String[] makeProgression() {
        int progressionLength = generator.nextInt(PROGRESSION_MIN_LENGTH, PROGRESSION_MAX_LENGTH + 1);
        String[] values = new String[progressionLength];

        int start = generator.nextInt(upperLimit + 1);
        values[0] = String.valueOf(start);

        int step = generator.nextInt((upperLimit + 1) / 2);

        for (var i = 1; i < progressionLength; i += 1) {
            values[i] = String.valueOf(start + i * step);
        }

        return values;
    }

    private String[][] makeQuestions() {
        String[][] questions = new String[tries][2];

        int hiddenIndex = 0;

        for (var i = 0; i < questions.length; i += 1) {
            var values = makeProgression();
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
                || (questions.length > MAX_TRIES_NUMBER)) {
            System.out.println("The game was terminated due to a logical error.");
            return;
        }

        Engine.play(task, questions);
    }
}

