package game;

public class TicTacToe extends Game {
//constructor to create a 3x3 board
	public TicTacToe(String player1, String player2) {
		super(3, 3, new Player(player1, 'X'), new Player(player2, 'O'));

	}
//checking for winner
	@Override
	protected boolean doesWin(int x, int y) {
		if (maxLineContaining(x, y) == 3)
			return true;
		return false;
	}

}
