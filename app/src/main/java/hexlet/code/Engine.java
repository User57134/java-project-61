package hexlet.code;

import java.util.Scanner;

public final class Engine {
    public static final int DEFAULT_TRIES_NUMBER = 3;

    private Engine() {

    }

    public static void play(String task, String[][] questions) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");

        String player = "Anonymous";
        if (reader.hasNext()) {
            player = reader.next();
        }

        System.out.println("Hello, " + player + "!");
        System.out.println(task);

        for (var i = 0; i < questions.length; i += 1) {

            System.out.println("Question: " + questions[i][0]);

            String answer = reader.next();

            if (questions[i][1].equals(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was '"
                        + questions[i][1] + "'.");
                System.out.println("Let's try again, " + player + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + player + "!");
    }
}
