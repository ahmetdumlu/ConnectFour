public class Board {

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;
	private char[][] boardState = new char[NUM_OF_ROW][NUM_OF_COLUMNS];
	/*
	 * The board object must contain the board state in some manner. You must decide
	 * how you will do this.
	 * 
	 * You may add addition private/public methods to this class is you wish.
	 * However, you should use best OO practices. That is, you should not expose how
	 * the board is being implemented to other classes. Specifically, the Player
	 * classes.
	 * 
	 */

	public Board() {
		for (int i = 0; i < NUM_OF_ROW; i++)
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				if (i == NUM_OF_ROW - 1)
					this.boardState[i][j] = '_';
				else
					this.boardState[i][j] = ' ';
			}
	}

	public void copyBoard(Board board) {
		for (int i = 0; i < NUM_OF_ROW; i++)
			for (int j = 0; j < NUM_OF_COLUMNS; j++)
				this.boardState[i][j] = board.boardState[i][j];

	}

	public void removePiece(int input) {
		int j = NUM_OF_ROW - 1;
		while (boardState[j][input - 1] != ' ' && boardState[j][input - 1] != '_') {
			j--;
		}
		if (j == NUM_OF_ROW - 1)
			boardState[j][input - 1] = '_';
		else
			boardState[j][input - 1] = ' ';
	}

	public int getNumRow() {
		return NUM_OF_ROW;
	}

	public int getNumCol() {
		return NUM_OF_COLUMNS;
	}

	public void printBoard() {
		for (int i = 0; i < NUM_OF_ROW; i++) {
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				System.out.print("|" + this.boardState[i][j]);

			}
			System.out.println("|\n");
		}
	}

	public boolean NotValid(int userInput, Player player) {
		int j = NUM_OF_ROW - 1;
		while (boardState[j][userInput - 1] != ' ' && boardState[j][userInput - 1] != '_') {
			j--;
			if (j < 0)
				return false;
		}
		return true;

	}

	public char[][] getBoard() {
		return boardState;
	}

	public void setBoard(int userInput, char symbol) {

		int j = NUM_OF_ROW - 1;
		while (boardState[j][userInput - 1] != ' ' && boardState[j][userInput - 1] != '_')
			j--;

		boardState[j][userInput - 1] = symbol;

	}

	public boolean containsWin() {
		// Horizontal search
		for (int i = NUM_OF_ROW - 1; i >= 0; i--)
			for (int j = 0; j < NUM_OF_COLUMNS - 3; j++) {
				if (boardState[i][j] == boardState[i][j + 1] && boardState[i][j] == boardState[i][j + 2]
						&& boardState[i][j] == boardState[i][j + 3]
						&& (boardState[i][j] != ' ' && boardState[i][j] != '_'))
					return true;
			}
		// Vertical search
		for (int i = NUM_OF_ROW - 1; i >= 3; i--)
			for (int j = 0; j < NUM_OF_COLUMNS; j++)
				if (boardState[i][j] == boardState[i - 1][j] && boardState[i][j] == boardState[i - 2][j]
						&& boardState[i][j] == boardState[i - 3][j]
						&& (boardState[i][j] != ' ' && boardState[i][j] != '_'))
					return true;
		// Right diagonal search
		for (int i = NUM_OF_ROW - 1; i >= 3; i--)
			for (int j = 0; j < NUM_OF_COLUMNS - 3; j++)
				if (boardState[i][j] == boardState[i - 1][j + 1] && boardState[i][j] == boardState[i - 2][j + 2]
						&& boardState[i][j] == boardState[i - 3][j + 3]
						&& (boardState[i][j] != ' ' && boardState[i][j] != '_'))
					return true;
		// Left Diagonal search
		for (int i = NUM_OF_ROW - 1; i >= 3; i--)
			for (int j = NUM_OF_COLUMNS - 1; j <= 3; j--)
				if (boardState[i][j] == boardState[i - 1][j - 1] && boardState[i][j] == boardState[i - 2][j - 2]
						&& boardState[i][j] == boardState[i - 3][j - 3]
						&& (boardState[i][j] != ' ' && boardState[i][j] != '_'))
					return true;
		return false;

	}

	public boolean isTie() {
		for (int i = 0; i < NUM_OF_ROW; i++)
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				if (boardState[i][j] == '_' || boardState[i][j] == ' ')
					return false;
			}
		return true;
	}

	public void reset() {
		for (int i = 0; i < NUM_OF_ROW; i++)
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				if (i == NUM_OF_ROW - 1)
					this.boardState[i][j] = '_';
				else
					this.boardState[i][j] = ' ';
			}
	}

	public void MakeFamiliar(Player player) {
		for (int i = 0; i < NUM_OF_ROW; i++)
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				if (this.boardState[i][j] != ' ' && this.boardState[i][j] != '_'
						&& this.boardState[i][j] != player.symbol) {
					boardState[i][j] = 'A';
				}

			}
	}
}
