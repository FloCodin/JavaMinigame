package minigame;

import java.util.Scanner;

public class Player {
    public static String[] getPlayerNames() {
        Scanner scanner = new Scanner(System.in);
        String[] playerNames = new String[2];

        System.out.println("Enter player 1's name:");
        playerNames[0] = scanner.nextLine();

        System.out.println("Enter player 2's name:");
        playerNames[1] = scanner.nextLine();
        System.out.println("Welcome to the Dice Game, " + playerNames[0] + " and " + playerNames[1] + "!");
        return playerNames;
    }
}
