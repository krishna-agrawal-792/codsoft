import java.util.Scanner;
import java.util.Random;

public class numberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between " + minRange + " and " + maxRange);

        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("A random number has been generated.");

            boolean guessedCorrectly = false;
            int attempts = 0;

            while (!guessedCorrectly && attempts < maxAttempts) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + maxAttempts + "): ");
                int guess = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                if (guess < minRange || guess > maxRange) {
                    System.out.println("Your guess is out of the valid range!");
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else if (guess > randomNumber) {
                    System.out.println("Too high! Try a lower number.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + randomNumber + " correctly!");
                    guessedCorrectly = true;
                    score++;
                }

                attempts++;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.nextLine().trim().toLowerCase();
            playAgain = playAgainResponse.equals("yes") || playAgainResponse.equals("y");
        }

        System.out.println("Game Over! Your total score is: " + score);
        scanner.close();
    }
}
