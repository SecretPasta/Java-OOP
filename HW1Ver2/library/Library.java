package library;

public class Library {

	private Book[] books;

	public Library(int size) {// Constructor for Library, creates an array with the size of "size"
		books = new Book[size];
	}

	public void setBook(int bookNum, String title, Author auth) {// method to add a book to the Array
		books[bookNum] = new Book(title, auth);
	}

	public Book getBook(int bookNum) { // method to retrieve a specific book using an index in the array
		return (books[bookNum]);

	}

}
