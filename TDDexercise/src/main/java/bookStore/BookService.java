package bookStore;

import java.util.HashMap;
import java.util.Map;

public class BookService {

	public Map<Integer, Book> bookMap = new HashMap<Integer, Book>();
	
	public int id;

	public void initBookStore() {
		Book aBook = new Book("James Herbert", "Rats", "Horror", "1988");
		Book anotherBook = new Book("Jim Bert", "Cats", "Comedy", "1898");
		bookMap.put(1, aBook);
		bookMap.put(2, anotherBook);
		id = 2;
	}

	public void addBook(String author, String title, String genre, String yearPublished) {
		id++;
		Book newBook = new Book(author, title, genre, yearPublished);
		bookMap.put(id, newBook);
		System.out.println("Added book: " + bookMap.get(id).getTitle());
	}

	public int countGenre(String genre) {
		int genreCount = 0;
		for (Book book : bookMap.values()) {
			if (genre.equals(book.getGenre())) {
				genreCount++;
			}
		}
		return genreCount;
	}
}