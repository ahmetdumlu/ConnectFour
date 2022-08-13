
/**
 * AIPlayer
 */

public class AIPlayer extends Player {

    public AIPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    public void makeMove(Board board) {

        Board tempBoard = new Board();
        tempBoard.copyBoard(board);
        int randMove = (int) ((Math.random() * 10000) % 7) + 1;
        // If there is a winning move
        for (int i = 1; i <= 7; i++) {
            tempBoard.setBoard(i, this.symbol);
            if (tempBoard.containsWin()) {
                board.setBoard(i, this.symbol);
                return;
            }
            tempBoard.removePiece(i);
        }
        // if there is a blocking move
        tempBoard.copyBoard(board);
        tempBoard.MakeFamiliar(this);
        for (int i = 1; i <= 7; i++) {
            tempBoard.setBoard(i, 'A');
            if (tempBoard.containsWin()) {
                board.setBoard(i, this.symbol);
                return;
            }
            tempBoard.removePiece(i);
        }

        // Random move
        board.setBoard(randMove, this.symbol);
    }
}