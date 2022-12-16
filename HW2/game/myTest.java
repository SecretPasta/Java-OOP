package game;

public class myTest {
	public static void main(String[] args) {
		Player p1 = new Player("Bibi", 'B');
		Player p2 = new Player("Gantz", 'G');
		Board b = new Board(3,4);
		b.set(0, 0, p1);
		b.set(1, 0, p1);
		b.set(2, 2, p2);
		b.set(0, 0, p2);
		b.set(0, 1, p1);
		System.out.print(b);

	}
}
