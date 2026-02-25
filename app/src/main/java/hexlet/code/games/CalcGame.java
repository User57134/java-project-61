package hexlet.code.games;


import java.security.SecureRandom;
import hexlet.code.Engine;


public final class CalcGame {
    private static final int DEFAULT_RADOM_MAX_VALUE = 100;
    public static final int MAX_TRIES_NUMBER = 3;
    private SecureRandom generator = null;
    private char[] operations = null;
    private int upperLimit;  // default value is 100
    private int tries;

    public CalcGame() {
        tries = MAX_TRIES_NUMBER;
        upperLimit = DEFAULT_RADOM_MAX_VALUE;
        generator = new SecureRandom();
        operations = new char[] {'+', '-', '*'};
    }

    private int calculate(int operand1, int operand2, int operation) {
        switch (operation) {
            case 0:
                return operand1 + operand2;
            case 1:
                return operand1 - operand2;
            case 2:
                return operand1 * operand2;
            default:
                throw new RuntimeException("Unknown user input " + operation);
        }
    }

    private String[][] makeQuestions() {
        String[][] questions = new String[tries][2];

        int operand1 = 0;
        int operand2 = 0;
        int operationIndex = 0;
        StringBuilder expression = null;
        for (var i = 0; i < questions.length; i += 1) {
            operand1 = generator.nextInt(upperLimit + 1);
            operand2 = generator.nextInt(upperLimit + 1);
            operationIndex = generator.nextInt(operations.length);

            expression = new StringBuilder();
            expression.append(operand1);
            expression.append(" ");
            expression.append(operations[operationIndex]);
            expression.append(" ");
            expression.append(operand2);

            questions[i][0] = expression.toString();
            questions[i][1] = String.valueOf(calculate(operand1, operand2, operationIndex));
        }

        return questions;
    }

    public void start() {
        String task = "What is the result of the expression?";
        var questions = makeQuestions();

        if ((questions == null) || (questions.length == 0)
                || (questions.length > MAX_TRIES_NUMBER)) {
            System.out.println("The game was terminated due to a logical error.");
            return;
        }

        Engine.play(task, questions);
    }
}
