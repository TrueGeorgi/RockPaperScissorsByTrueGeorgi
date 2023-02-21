import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rock = "Rock";
        String paper = "Paper";
        String scissors = "scissors";

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
        } else if ((playerMove.equals(rock) && computerMoveString.equals(paper)) ||
                (playerMove.equals(paper) && computerMoveString.equals(scissors)) ||
        playerMove.equals(scissors) && computerMoveString.equals(rock)) {
            System.out.println("You lose!");
        } else {
            System.out.println("It ends as a draw!");
        }
    }
}