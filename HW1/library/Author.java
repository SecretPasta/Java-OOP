package library;

public class Author {

	private String name;
	private int birthYear;

	public Author(String name, int birthYear) {// Constructor for Author
		this.name = name;
		this.birthYear = birthYear;

	}

	public String getName() { // method to return author name
		return name;
	}

	public int getBirthYear() {// method to return author birth year
		return birthYear;
	}

	public int getAge(int thisYear) { // method to calculate and return author age
		return Math.abs(thisYear - birthYear);
	}

	public String toString() { // method to print a formated string of name a birth year
		return (name + "(" + birthYear + ")");

	}

}
