import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int maxAttempts = 7;
        int roundsWon = 0;
        int totalRounds = 0;
        boolean playAgain = true;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        while (playAgain) {
            int numberToGuess = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.printf("\nI'm thinking of a number between %d and %d. You have %d attempts.\n", min, max, maxAttempts);
            
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }
                
                attempts++;
                
                if (guess == numberToGuess) {
                    System.out.printf("Correct! You guessed the number in %d attempts.\n", attempts);
                    guessedCorrectly = true;
                    roundsWon++;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.printf("Sorry, you've used all %d attempts. The number was %d.\n", maxAttempts, numberToGuess);
            }
            
            totalRounds++;
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }
        
        System.out.printf("\nGame Over! You won %d out of %d rounds.\n", roundsWon, totalRounds);
        scanner.close();
    }
}