import java.util.Scanner;

public class Main {
    private static Card[][] cards = new Card[4][4];
    private static int score = 0;

    public static void main(String[] args) {
        // fill cards
        cards[0][1] = new Card('A');
        cards[0][2] = new Card('B');
        cards[0][0] = new Card('E');
        cards[1][1] = new Card('A');
        cards[0][3] = new Card('F');
        cards[2][1] = new Card('C');
        cards[1][0] = new Card('G');
        cards[2][3] = new Card('H');
        cards[1][2] = new Card('D');
        cards[1][3] = new Card('H');
        cards[3][3] = new Card('C');
        cards[2][0] = new Card('F');
        cards[2][2] = new Card('D');
        cards[3][1] = new Card('G');
        cards[3][2] = new Card('B');
        cards[3][0] = new Card('E');

        while (!isGameOver()) {
            gameBoard();
            guess();
        }

        System.out.println("Game Over! Your final score is: " + score);
    }

    public static void gameBoard() {
        for (int i = 0; i < 4; i++) {
            System.out.println("-----------------------------------");
            for (int j = 0; j < 4; j++) {
                if (cards[i][j].isGuess()) {
                    System.out.print(" |" + cards[i][j].getValue() + "| ");
                } else {
                    System.out.print(" | | ");
                }
            }
            System.out.println("");
        }
        System.out.println("-----------------------------------");
    }

    public static boolean isGameOver() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!cards[i][j].isGuess()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void guess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("First Guess (Enter the values for First and Second separated by a space): ");
        int i1 = scanner.nextInt();
        int j1 = scanner.nextInt();
        cards[i1][j1].setGuess(true);
        gameBoard();

        System.out.print("Second Guess (Enter the values for First and Second separated by a space): ");
        int i2 = scanner.nextInt();
        int j2 = scanner.nextInt();
        cards[i1][j1].setGuess(true);

        if (cards[i1][j1].getValue() == cards[i2][j2].getValue()) {
            System.out.println("Correct Guess. Congrats!");
            cards[i2][j2].setGuess(true);
            score++;
        } else {
            System.out.println("Wrong Guess. Sorry!!");
            cards[i1][j1].setGuess(false);
        }

        System.out.println("Current Score: " + score);
    }
}