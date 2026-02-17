package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greating() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");

        String user = "";
        if (scanner.hasNext()) {
            user = scanner.next();
        }

        System.out.println("Hello, " + user + "!");

        scanner.close();
    }
}
