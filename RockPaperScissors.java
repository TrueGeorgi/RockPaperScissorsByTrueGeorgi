import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rock = "Rock";
        String paper = "Paper";
        String scissors = "scissors";

        boolean gamesContinues = true;

        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;

        while (gamesContinues) {

            System.out.println("Choose rock, paper or scissors: ");
            String playerMove = scanner.nextLine().toLowerCase();

            if (playerMove.equals("rock")) {
                playerMove = rock;
            } else if (playerMove.equals("paper")) {
                playerMove = paper;
            } else if (playerMove.equals("scissors")) {
                playerMove = scissors;
            } else {
                System.out.println("Such a move doesn't exist. Try agan");
                return;
            }

            Random random = new Random();
            int computerMoveNumber = random.nextInt(4);
            while (computerMoveNumber == 0) {
                computerMoveNumber = random.nextInt(4);
            }
            String computerMoveString = "";
            switch (computerMoveNumber) {
                case 1:
                    computerMoveString = rock;
                    break;
                case 2:
                    computerMoveString = paper;
                    break;
                case 3:
                    computerMoveString = scissors;
                    break;
            }
            System.out.printf("The opponent chose %s.%n", computerMoveString);
            if ((playerMove.equals(rock) && computerMoveString.equals(scissors)) ||
                    (playerMove.equals(paper) && computerMoveString.equals(rock)) ||
                    (playerMove.equals(scissors) && computerMoveString.equals(paper))) {
                System.out.println("You are the winner!");
                playerWins++;
            } else if ((playerMove.equals(rock) && computerMoveString.equals(paper)) ||
                    (playerMove.equals(paper) && computerMoveString.equals(scissors)) ||
                    playerMove.equals(scissors) && computerMoveString.equals(rock)) {
                System.out.println("You lose!");
                computerWins++;
            } else {
                System.out.println("It ends as a draw!");
                draws++;
            }

            System.out.println("Do you want another game?");
            String answer = scanner.nextLine().toLowerCase();
            boolean correctInput = false;
            while (!correctInput) {
                if (answer.equals("yes")) {
                    correctInput = true;
                } else if (answer.equals("no")) {
                    gamesContinues = false;
                    correctInput = true;
                } else {
                    System.out.println("Only yes or no, please.");
                    answer = scanner.nextLine();
                }
            }
        }
        System.out.printf("You won %d times.%n", playerWins);
        System.out.printf("The game ended as a draw %d times.%n",draws);
        System.out.printf("You lost %d times.%n", computerWins);
    }
}