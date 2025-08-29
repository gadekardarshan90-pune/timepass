import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Step 1: Generate a random number between 1 and 100 (originally it genrate numbers from 0 to 99 but we add 1 in this so it genrate number form 1 to 100)
        int randomNumber = random.nextInt(100) + 1;
        int userGuess;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've picked a number between 1 and 100. Try to guess it!");

        // Step 2 & 3: Prompt and compare until correct (we repeat untill randome valu match ented value)
        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number!");
                hasGuessedCorrectly = true;
            } else if (userGuess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Too low! Try again.");
            }
        }
        scanner.close();
    }
}