package hexlet.code;

import java.util.Scanner;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import org.apache.commons.lang3.math.NumberUtils;


public class App {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("0 - Exit");
        System.out.print("Your chois: ");

        int chois = 0;
        if (reader.hasNext()) {
            chois = NumberUtils.toInt(reader.next(), 0);
        }

        switch (chois) {
            case 1:
                Cli.greating();
                break;
            case 2:
                Engine.play(new EvenGame(200));
                break;
            case 3:
                Engine.play(new CalcGame());
                break;
            case 4:
                Engine.play(new GcdGame());
                break;
            default:
                break;
        }

        System.out.println("closing...");
    }
}
