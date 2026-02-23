package hexlet.code;

import java.util.Scanner;

import hexlet.code.games.EvenGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;
import org.apache.commons.lang3.math.NumberUtils;


public class App {
    private static final int MENU_EXIT = 0;
    private static final int MENU_GREET = 1;
    private static final int MENU_EVEN = 2;
    private static final int MENU_CALC = 3;
    private static final int MENU_GCD = 4;
    private static final int MENU_PROGRESSION = 5;
    private static final int MENU_PRIME = 6;

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

        int chois = 0;
        if (reader.hasNext()) {
            chois = NumberUtils.toInt(reader.next(), 0);
        }

        switch (chois) {
            case MENU_GREET:
                Cli.greating();
                break;
            case MENU_EVEN:
                int randomMaxValue = 200;
                Engine.play(new EvenGame(randomMaxValue));
                break;
            case MENU_CALC:
                Engine.play(new CalcGame());
                break;
            case MENU_GCD:
                Engine.play(new GcdGame());
                break;
            case MENU_PROGRESSION:
                Engine.play(new ProgressionGame());
                break;
            case MENU_PRIME:
                Engine.play(new PrimeGame());
                break;
            default:
                break;
        }

        System.out.println("closing...");
    }
}
