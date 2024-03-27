package minigame;

import java.util.Scanner;

public class GameMechanic {

        public static void main (String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Import the Player class
            String[] playerNames = Player.getPlayerNames();

            int currentPlayerIndex = 0;
            int[] scores = new int[2];

            boolean gameOver = false;
            while (!gameOver) {
                System.out.println(playerNames[currentPlayerIndex] + "'s turn to roll the dice. Press enter to roll...");
                scanner.nextLine();
                int diceRoll = rollDice();
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

        private static int rollDice() {
            return (int) (Math.random() * 6) + 1;
        }
    }