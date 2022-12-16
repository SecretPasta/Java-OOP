package library;

public class Book {

	private String title;
	private Author auth = new Author(title, 0);

	public Book(String title, Author auth) {// Constructor for Book
		this.title = title;
		this.auth = auth;

	}

	public String getTitle() {// method to get Book title
		return title;
	}

	public String getAuthorName() {// method to get Author name
		return auth.getName();
	}

	public int getAuthorBirthYear() {// method to get Author birth year
		return auth.getBirthYear();
	}

	public String toString() {// method to print a formated string of the book and who wrote it
		return (title + " written by " + auth.toString());
	}

}
