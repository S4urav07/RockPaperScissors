package RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        String[] choices = {"rock", "paper", "scissors"};
        int userScore = 0, computerScore = 0;
        
        while (true) {
            System.out.print("Enter rock, paper, or scissors (or 'exit' to quit): ");
            
            // Check if input is available
            if (!scanner.hasNextLine()) {
                System.out.println("\nInput closed unexpectedly. Exiting game...");
                break;
            }

            String userChoice = scanner.nextLine().trim().toLowerCase();

            if (userChoice.equals("exit")) {
                System.out.println("\nGame Over!");
                System.out.println("Final Score: You " + userScore + " - " + computerScore + " Computer");
                System.out.println("Thanks for playing!");
                break;
            }

            // Validate input
            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid choice. Try again.\n");
                continue;
            }

            // Computer's choice
            String computerChoice = choices[random.nextInt(3)];
            System.out.println("Computer chose: " + computerChoice);

            // Determine Winner
            if (userChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if (
                (userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                (userChoice.equals("scissors") && computerChoice.equals("paper"))
            ) {
                System.out.println("You win!");
                userScore++;
            } else {
                System.out.println("You lose!");
                computerScore++;
            }

            System.out.println("Current Score: You " + userScore + " - " + computerScore + " Computer\n");
        }
        
        scanner.close();
    }
}
