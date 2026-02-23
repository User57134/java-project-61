package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.Question;
import java.security.SecureRandom;

public final class CalcGame implements Game {
    private static final int DEFAULT_RADOM_MAX_VALUE = 100;
    private SecureRandom generator = null;
    private char[] operations = null;
    private int upperLimit;

    public CalcGame(int randomMaxValue) {
        upperLimit = randomMaxValue;
        generator = new SecureRandom();
        operations = new char[] {'+', '-', '*'};
    }

    public CalcGame() {
        this(DEFAULT_RADOM_MAX_VALUE);
    }

    @Override
    public String getTask() {
        return "What is the result of the expression?";
    }

    @Override
    public Question makeQuestion() {
        int operand1 = generator.nextInt(upperLimit + 1);
        int operand2 = generator.nextInt(upperLimit + 1);
        int operationIndex = generator.nextInt(operations.length);

        Integer result = null;
        StringBuilder expression = new StringBuilder();
        expression.append(operand1);
        expression.append(" ");
        expression.append(operations[operationIndex]);
        expression.append(" ");
        expression.append(operand2);

        switch (operationIndex) {
            case 0:
                result = operand1 + operand2;
                break;
            case 1:
                result = operand1 - operand2;
                break;
            case 2:
                result = operand1 * operand2;
                break;
            default:
                return null;
        }

        return new Question(expression.toString(), String.valueOf(result));
    }
}
