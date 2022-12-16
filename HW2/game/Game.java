package game;

import java.util.Scanner;

public class Game extends Board {
	protected Player[] players;
	protected Scanner s;

	public Game(int n, int m, Player p1, Player p2) {
		super(n, m);
		players = new Player[2];
		players[0] = p1;
		players[1] = p2;
		s = new Scanner(System.in);

	}

	protected boolean doesWin(int i, int j) {
		if (i == 0 && j == 0)
			return true;
		return false;
	}

	protected boolean onePlay(Player p) {
		int x, y;
		System.out.format("%s(%c), please enter x and y:\n", p.getName(), p.getMark());
		x = s.nextInt();
		y = s.nextInt();
		set(x, y, p);
		if (doesWin(x, y)) {
			return true;
		}
		return false;
	}

	public Player play() {
		while (true) {
			if (onePlay(players[0]))
				return players[0];
			if (super.isFull())
				break;
			if (onePlay(players[1]))
				return players[1];
			if (super.isFull())
				break;
		}

		return null;
	}
}
