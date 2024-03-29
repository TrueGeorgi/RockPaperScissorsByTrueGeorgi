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

        int timesRock = 0;
        int timesPaper = 0;
        int timesScissors = 0;
        int timesPlayed = 0;

        while (gamesContinues) {
            timesPlayed++;
            System.out.println("Choose rock, paper or scissors: ");
            String playerMove = scanner.nextLine().toLowerCase();
            while (!playerMove.equals("rock") && !playerMove.equals("scissors") && !playerMove.equals("paper")) {
                playerMove = scanner.nextLine().toLowerCase();
            }

            if (playerMove.equals("rock")) {
                playerMove = rock;
                timesRock++;
            } else if (playerMove.equals("paper")) {
                playerMove = paper;
                timesPaper++;
            } else if (playerMove.equals("scissors")) {
                playerMove = scissors;
                timesScissors++;
            }
//file named RockPaperScissors.java
            Random random = new Random();
            int computerMoveNumber = random.nextInt(4);
            while (computerMoveNumber == 0) {
                computerMoveNumber = random.nextInt(4);
            }
            String computerMoveString = "";
            switch (computerMoveNumber) {
                case 1:
                    computerMoveString = rock;
                    timesRock++;
                    break;
                case 2:
                    computerMoveString = paper;
                    timesPaper++;
                    break;
                case 3:
                    computerMoveString = scissors;
                    timesScissors++;
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
        double percentageRock = timesRock / (timesPlayed * 2.0) * 100;
        double percentagePaper = timesPaper / (timesPlayed * 2.0) * 100;
        double percentageScissors = timesScissors / (timesPlayed * 2.0) * 100;

        System.out.printf("Rock was chosen %d times (%.2f%%)%n",timesRock, percentageRock);
        System.out.printf("Paper was chosen %d times (%.2f%%)%n",timesPaper, percentagePaper);
        System.out.printf("Scissors was chosen %d times (%.2f%%)%n",timesScissors, percentageScissors);
    }
}