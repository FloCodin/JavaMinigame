package minigame;


import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        int square = number * number;

        System.out.println(square);

        scanner.close();
    }
}