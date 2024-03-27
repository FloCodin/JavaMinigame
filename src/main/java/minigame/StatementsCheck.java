package minigame;

public class StatementsCheck {
    public static void main(String[] args) {
        int counter = 0;

        // BLOCK XYZ
        do {
            System.out.println("XYZ: " + counter);
            counter += 1;
        } while (counter < 2);

        // BLOCK ABC
        while (counter < 3) {
            System.out.println("ABC: " + counter);
            counter -= 1;
        }

        System.out.println("Fertig");
    }
}
