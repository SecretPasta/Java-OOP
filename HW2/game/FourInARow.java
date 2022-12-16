package game;

public class FourInARow extends Game {
//constructor to create a board and initialize players
	public FourInARow(String player1, String player2) {
		super(7, 6, new Player(player1, 'W'), new Player(player2, 'B'));
	}
//checking if won
	@Override
	protected boolean doesWin(int i, int j) {
		if (maxLineContaining(i, j) == 4)
			return true;
		return false;
	}
//letting one player play
	@Override
	protected boolean onePlay(Player p) {
		int x;
		while (true) {
			System.out.format("%s(%c), please enter column:\n", p.getName(), p.getMark());
			x = s.nextInt();
			if (!(getColumnLen(x) == 5))
				break;
		}

		set(x, getColumnLen(x), p);
		if (doesWin(x, getColumnLen(x)))
			return true;

		return false;
	}
//asist method to get a columns length
	private int getColumnLen(int x) {
		int height = 0;
		Player blank = new Player("", '.');
		for (int i = 0; i < 6; i++) {
			if (super.board[x][i].equals(blank)) {
				height = i;
				break;
			}
		}
		return height;
	}

}
