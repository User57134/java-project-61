package hexlet.code;

import java.util.Scanner;
import org.apache.commons.lang3.math.NumberUtils;


public class App {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
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
                EvenGame.play();
                break;
            default:
                break;
        }

        System.out.println("closing...");
    }
}
