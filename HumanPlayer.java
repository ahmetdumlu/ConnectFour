import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    public void makeMove(Board board) {

        Scanner sc = new Scanner(System.in);
        int userInput;
        do {
            System.out.print(this.getName() + ", please input your move: ");
            userInput = sc.nextInt();
        } while (!board.NotValid(userInput, this));

        board.setBoard(userInput, this.symbol);

    }
}
