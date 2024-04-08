package minigame;

import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        GameLogic gameLogic = new GameLogic();
        gameLogic.startGame();
    }
}

class PlayerRelated {
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

class DiceRoll {
    public static int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }

}


 class GameLogic {
    private Scanner scanner = new Scanner(System.in);
    private String[] playerNames;
    private int currentPlayerIndex = 0;
    private int[] scores = new int[2];
    private boolean gameOver = false;

    public GameLogic() {
        playerNames = PlayerRelated.getPlayerNames(); // Assuming PlayerRelated is another class you've defined
    }

    public void startGame() {
        while (!gameOver) {
            System.out.println(playerNames[currentPlayerIndex] + "'s turn to roll the dice. Press enter to roll...");
            scanner.nextLine();
            int diceRoll = DiceRoll.rollDice(); // Assuming DiceRoll is another class you've defined
            System.out.println(playerNames[currentPlayerIndex] + " rolled a " + diceRoll + "!");

            if (diceRoll == 6) {
                System.out.println("Oops! You rolled a 6. You lose!");
                scores[currentPlayerIndex] = 0;
            } else {
                scores[currentPlayerIndex] += diceRoll; // Add score
                System.out.println("Your total score is: " + scores[currentPlayerIndex]);
                System.out.println("Do you want to continue rolling? (y/n)");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("n")) {
                    System.out.println(playerNames[currentPlayerIndex] + " decided to keep the current score.");
                    if (scores[currentPlayerIndex] >= 40) {
                        System.out.println(playerNames[currentPlayerIndex] + " wins with a score of " + scores[currentPlayerIndex] + "!");
                        gameOver = true;
                    }
                } else {
                    if (scores[currentPlayerIndex] >= 40) {
                        System.out.println(playerNames[currentPlayerIndex] + " wins with a score of " + scores[currentPlayerIndex] + "!");
                        gameOver = true;
                    }
                }
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % 2;
        }

        System.out.println("Thanks for playing!");
    }
}