public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.printBoard();
        ConnectFour game = new ConnectFour(board);
        game.setPlayer1(new HumanPlayer('R', board, "Alice"));
        // game.setPlayer2(new HumanPlayer('B', board, "Bob"));
        game.setPlayer2(new AIPlayer('B', board, "Matrix"));
        game.playGame();
    }
}
