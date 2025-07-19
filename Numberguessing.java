import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int score = 0;
        int round = 0;
        boolean playAgain = true;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = rand.nextInt(100) + 1;
            int attemptsLeft = 7;
            boolean guessedCorrectly = false;

            round++;
            System.out.println("\n🎮 Round " + round + " Begins!");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have " + attemptsLeft + " attempts to guess it!");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attemptsLeft--;

                if (guess == numberToGuess) {
                    System.out.println("✅ Correct! You've guessed the number!");
                    score += (7 - attemptsLeft);  // fewer attempts = better score
                    guessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("📉 Too low!");
                } else {
                    System.out.println("📈 Too high!");
                }

                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Out of attempts! The number was: " + numberToGuess);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            sc.nextLine(); // consume leftover newline
            String response = sc.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n🏁 Game Over! Total Rounds: " + round);
        System.out.println("⭐ Final Score: " + score);
        System.out.println("Thanks for playing!");
        sc.close();
    }
}
