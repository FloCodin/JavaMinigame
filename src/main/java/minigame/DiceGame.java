package minigame;
import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int numOfPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Player[] players = new Player[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.print("Enter name for Player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            players[i] = new Player(playerName);
        }

        Game game = new Game(players);
        game.start();
    }
}

class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int points) {
        score += points;
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
            System.out.println(currentPlayer.getName() + " rolled a " + diceRoll + "!");

            if (diceRoll == 6) {
                System.out.println("Oops! You rolled a 6. You lose!");
                currentPlayer.resetScore();
                // Spieler wechselt nach jedem Wurf, auch wenn eine 6 gewürfelt wurde
            } else {
                currentPlayer.addToScore(diceRoll);
                System.out.println("Your total score is: " + currentPlayer.getScore());

                if (currentPlayer.getScore() >= 40) {
                    System.out.println(currentPlayer.getName() + " wins with a score of " + currentPlayer.getScore() + "!");
                    gameOver = true;
                    break; // Beendet die Schleife, wenn ein Spieler gewinnt
                }

                System.out.println("Do you want to continue rolling? (y/n)");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("n")) {
                    System.out.println(currentPlayer.getName() + " decided to keep the current score.");
                }
                // Wenn der Spieler entscheidet weiterzumachen und keine 6 gewürfelt hat, wird der Spieler am Ende des Zuges trotzdem gewechselt.
            }

            // Aktualisiert den Index des aktuellen Spielers nach jedem Wurf
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        }
        System.out.println("Thanks for playing!");
    }
}