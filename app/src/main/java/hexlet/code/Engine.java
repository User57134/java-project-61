package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int DEFAULT_TRIES_NUMBER = 3;

    private Engine() {

    }

    public static void play(Game game) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");

        String player = "Anonymous";
        if (reader.hasNext()) {
            player = reader.next();
        }

        System.out.println("Hello, " + player + "!");
        System.out.println(game.getTask());

        for (int i = 1; i <= DEFAULT_TRIES_NUMBER; i += 1) {
            var question = game.makeQuestion();
            if (question == null) {
                System.out.println("The game finished. Engine's logic error. Try later.");
                return;
            }
            System.out.println("Question: " + question.getText());

            String playerAnswer = reader.next();

            if (question.check(playerAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + playerAnswer + "'" + " is wrong answer ;(. Correct answer was '"
                        + question.getAnswer() + "'.");
                System.out.println("Let's try again, " + player);
                return;
            }
        }

        System.out.println("Congratulations, " + player + "!");
    }
}
