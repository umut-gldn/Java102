package game.manager;

import java.util.Scanner;

public class InputManager {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        return scanner.nextInt();
    }

    public static String getString() {
        return scanner.next();
    }

}
