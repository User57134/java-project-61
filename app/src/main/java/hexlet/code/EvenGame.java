package hexlet.code;

import java.util.Scanner;
import java.util.Random;

public final class EvenGame {
    public static final int defaultRandomRangeMax = 100;
    public static final int defaultTriesNumber = 3;
    private static Random generator = null;

    private EvenGame() {

    }

    public static void play() {
        Scanner reader = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");

        String player = "Anonymous";
        if (reader.hasNext()) {
            player = reader.next();
        }

        System.out.println("Hello, " + player + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        if (generator == null) {
            generator = new Random();
        }

        for (int i = 1; i <= defaultTriesNumber; i += 1) {
            int number = generator.nextInt(defaultRandomRangeMax); // Random from 0 to defaultRandomRangeMax
            System.out.println("Question: " + number);

            String answer = reader.next();

            if (((number % 2 == 0) && (answer.equals("yes")))
                    || ((number % 2 != 0) && (answer.equals("no")))) {
                System.out.println("Correct!");
            } else {
                System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
                System.out.println("Let's try again, " + player);
                return;
            }
        }

        System.out.println("Congratulations, " + player + "!");
    }
}
