package minigame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class DiceGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            System.out.print("Enter number of players: ");
            int numOfPlayers = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            Player[] players = new Player[numOfPlayers];
            for (int i = 0; i < numOfPlayers; i++) {
                System.out.print("Enter name for Player " + (i + 1) + ": ");
                String playerName = scanner.nextLine();
                players[i] = new Player(playerName);
            }

            Game game = new Game(players);
            game.start();

            // Ask if the players want to play again
            System.out.println("Would you like to play again? (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();
            playAgain = input.equals("y");

        } while (playAgain);

        System.out.println("Thanks for playing!");
    }
}

class Player {
    private String name;
    private int score;
    private int rollCount;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.rollCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getRollCount() {
        return rollCount;
    }

    public void addToScore(int points) {
        score += points;
    }

    public void incrementRollCount() {
        rollCount++;
    }

    public void resetScore() {
        score = 0;
    }
}

class Dice {
    public static int roll() {
        return (int) (Math.random() * 6) + 1;
    }
}

class Game {
    private Player[] players;
    private int currentPlayerIndex;
    private boolean gameOver;
    private Scanner scanner;

    public Game(Player[] players) {
        this.players = players;
        this.currentPlayerIndex = 0;
        this.gameOver = false;
        this.scanner = new Scanner(System.in);
    }


    public void start() {
        while (!gameOver) {
            Player currentPlayer = players[currentPlayerIndex];
            System.out.println(currentPlayer.getName() + "'s turn to roll the dice. Press enter to roll...");
            scanner.nextLine();
            int diceRoll = Dice.roll();
            currentPlayer.incrementRollCount();
            System.out.println(currentPlayer.getName() + " rolled a " + diceRoll + "!");

            if (diceRoll == 6) {
                System.out.println("Oops! You rolled a 6. You lose!");
                currentPlayer.resetScore();

            } else {
                currentPlayer.addToScore(diceRoll);
                System.out.println("Your total score is: " + currentPlayer.getScore());

                if (currentPlayer.getScore() >= 40) {
                    System.out.println(currentPlayer.getName() + " wins with a score of " + currentPlayer.getScore() + "!");
                    gameOver = true;
                    break;
                }

                System.out.println("Do you want to continue rolling? (y/n)");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("n")) {
                    System.out.println(currentPlayer.getName() + " decided to keep the current score.");
                }
            }
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        }
        if (gameOver) {
            calculateRankings();
            endGame();

            System.out.println("Thanks for playing!");
        }
    }

    public void calculateRankings() {
        ArrayList<Player> sortedPlayers = new ArrayList<>(Arrays.asList(players));

        sortedPlayers.sort(Comparator.comparingInt(p -> Math.abs(40 - p.getScore())));

        System.out.println("\nRankings:");
        for (int i = 0; i < sortedPlayers.size(); i++) {
            Player player = sortedPlayers.get(i);
            int difference = Math.abs(40 - player.getScore());
            System.out.println("After " + player.getRollCount() + " rounds the winner is:");
            System.out.println((i + 1) + ". " + player.getName() + " - Score: " + player.getScore() + ", Difference from 40: " + difference);
        }

    }

    public void endGame() {
        Player winner = null;
        for (Player player : players) {
            if (player.getScore() >= 40) {
                winner = player;
                break;
            }
        }

        if (winner != null) {
            DatabaseWriter.insertGameResults(winner.getName(), winner.getScore(), winner.getRollCount());
            System.out.println("Game result inserted successfully for player: " + winner.getName());
        } else {
            System.out.println("No winner found to insert into database.");
        }
    }
}


