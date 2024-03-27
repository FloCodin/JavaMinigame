package GuiMinigame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DiceRollGameGUI extends JFrame {
// this is created with chatGPT
    private JButton rollButton;
    private JLabel diceLabel;
    private JLabel scoreLabel;
    private Random random;
    private int totalScore;

    public DiceRollGameGUI() {
        setTitle("Dice Roll Game");
        setSize(600, 500); // Double the size
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        rollButton = new JButton("Roll Dice");
        diceLabel = new JLabel();
        scoreLabel = new JLabel("Total Score: 0");
        random = new Random();

        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalScore = 0; // Reset total score
                updateScoreLabel();
                rollDice();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(rollButton);

        JPanel scorePanel = new JPanel();
        scorePanel.add(scoreLabel);

        add(buttonPanel, BorderLayout.NORTH);
        add(diceLabel, BorderLayout.CENTER);
        add(scorePanel, BorderLayout.SOUTH);
    }

    private void rollDice() {
        // Generate a random dice roll (1-6)
        int diceRoll = random.nextInt(6) + 1;

        // Display rolling animation
        for (int i = 0; i < 10; i++) {
            final int roll = i + 1;
            final int rollValue = diceRoll; // Create a final copy of diceRoll
            Timer timer = new Timer(200 * (i + 1), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    diceLabel.setText("Rolling... " + roll);
                    if (roll == 10) {
                        diceLabel.setText("You rolled a " + rollValue + "!");
                        if (rollValue != 6) {
                            totalScore += rollValue; // Accumulate score if the roll is not a six
                            updateScoreLabel();
                            int choice = JOptionPane.showConfirmDialog(null, "Do you want to risk your score and roll again?", "Continue?", JOptionPane.YES_NO_OPTION);
                            if (choice != JOptionPane.YES_OPTION) {
                                JOptionPane.showMessageDialog(null, "Great work! You achieved " + totalScore + " points.");
                                choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again?", JOptionPane.YES_NO_OPTION);
                                if (choice != JOptionPane.YES_OPTION) {
                                    System.exit(0);
                                }
                            } else {
                                rollDice(); // Roll again if player chooses to continue
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Oops! You rolled a 6. You lose!");
                            int choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again?", JOptionPane.YES_NO_OPTION);
                            if (choice != JOptionPane.YES_OPTION) {
                                System.exit(0);
                            }
                        }
                    }
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    private void updateScoreLabel() {
        scoreLabel.setText("Total Score: " + totalScore);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DiceRollGameGUI().setVisible(true);
            }
        });
    }
}
