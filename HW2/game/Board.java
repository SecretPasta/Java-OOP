package game;

public class Board {
	protected Player[][] board;
	protected int n, m;
	private Player def = new Player("", '.');
//constructor to create and initialize the board
	public Board(int n, int m) {
		this.n = n;
		this.m = m;
		board = new Player[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				board[i][j] = def;
			}
	}
//setting a cell on the board
	protected boolean set(int i, int j, Player p) {
		// if(i>=n || j>=m)
		// return false;

		if (board[i][j].equals(def)) {
			board[i][j] = p;

			return true;
		}
		return false;
	}
//checking if a cell is empty
	public boolean isEmpty(int i, int j) {
		if (board[i][j].equals(def))
			return true;
		return false;
	}
//Returning the player in a cell
	public Player get(int i, int j) {
		return board[i][j];
	}
//checking if the board is full
	public boolean isFull() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j].equals(def))
					return false;
			}
		}
		return true;
	}

	public String toString() {
		StringBuilder sBoard = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j].equals(def))
					sBoard.append(".");
				else {
					sBoard.append(board[i][j].getMark());

				}
			}
			sBoard.append("\n");
		}
		return sBoard.toString();
	}

	protected int maxLineContaining(int i, int j) {
		// System.out.printf("%d %d\n",i,j);
		int maxLine = 0, Hoz = 1, Ver = 1, Diag1 = 1, Diag2 = 1;
		Hoz += rayLength(i, j, 1, 0);
		Hoz += rayLength(i, j, -1, 0);
		Ver += rayLength(i, j, 0, 1);
		Ver += rayLength(i, j, 0, -1);
		Diag1 += rayLength(i, j, 1, 1);
		Diag1 += rayLength(i, j, -1, -1);
		Diag2 += rayLength(i, j, -1, 1);
		Diag2 += rayLength(i, j, 1, -1);
		if (Hoz >= maxLine)
			maxLine = Hoz;
		if (Ver >= maxLine)
			maxLine = Ver;
		if (Diag1 >= maxLine)
			maxLine = Diag1;
		if (Diag2 >= maxLine)
			maxLine = Diag2;
		return maxLine;
	}

	private int rayLength(int x, int y, int dx, int dy) {
		int len = 0;
		Player tempP = board[x][y];
		while (true) {
			x = x + dx;
			y = y + dy;
			if (x == -1 || y == -1 || x == n || y >= m)
				break;
			if (board[x][y].equals(tempP))
				len++;
		}
		return len;
	}

}

/*
 * for (dx = -1; dx <= 1; dx++) for (dy = -1; dy < +1; dy++) { temp =
 * rayLength(i, j, dx, dy); if (temp >= maxLine) maxLine = temp; }
 */
