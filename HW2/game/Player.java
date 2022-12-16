package game;

public class Player {
	private String name;
	private char mark;
//Constructor to initilaize fields
	public Player(String name, char mark) {
		super();
		this.name = name;
		this.mark = mark;
	}
//returns player names
	public String getName() {
		return name;
	}
//returns player mark
	public char getMark() {
		return mark;
	}
//string of player name and mark
	public String toString() {
		return name + "(" + mark + ")";
	}

}
