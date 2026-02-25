package hexlet.code;

import java.util.Scanner;

import hexlet.code.games.EvenGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;

public class App {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your chois: ");

        String chois = "0";
        if (reader.hasNext()) {
            chois = reader.next();
        }

        switch (chois) {
            case "0":
                break;
            case "1":
                Cli.greating();
                break;
            case "2":
                var evenGame = new EvenGame();
                evenGame.start();
                break;
            case "3":
                var calcGame = new CalcGame();
                calcGame.start();
                break;
            case "4":
                var gcdGame = new GcdGame();
                gcdGame.start();
                break;
            case "5":
                var progressionGame = new ProgressionGame();
                progressionGame.start();
                break;
            case "6":
                var primeGame = new PrimeGame();
                primeGame.start();
                break;

            default:
                System.out.println("Invalid number entered: " + chois);
                break;
        }

        System.out.println("closing...");
    }
}
