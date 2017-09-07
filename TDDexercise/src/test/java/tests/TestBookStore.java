package tests;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bookStore.Book;
import bookStore.BookService;

public class TestBookStore {

	BookService testBookService = new BookService();
	Book testBook;
	Map<Integer, Book> testMap;
	Integer id;
	
	@Test
	public void testGetAuthor() {
		this.testBook = new Book("testAuthor", "t", "g", "y");
		assertEquals("Couldn't find correct author", testBook.getAuthor(), "testAuthor");
	}
	
	@Test
	public void testGetTitle() {
		this.testBook = new Book("a", "testTitle", "g", "y");
		assertEquals("Couldn't find correct title", testBook.getTitle(), "testTitle");
	}
	
	@Test
	public void testGetGenre() {
		this.testBook = new Book("a", "t", "testGenre", "y");
		assertEquals("Couldn't find correct genre", testBook.getGenre(), "testGenre");
	}
	
	@Test
	public void testGetPublished() {
		this.testBook = new Book("a", "t", "g", "testYear");
		assertEquals("Couldn't find correct year", testBook.getYearPublished(), "testYear");
	}
	

	@Test
	public void testInitBooks() {
		testBookService.initBookStore();
		assertNotNull("Map not initialised", bookMap);
		assertEquals("Book 1 not added", bookMap.get(1).getAuthor(), "James Herbert");
		assertEquals("Book 2 not added", bookMap.get(2).getAuthor(), "Jim Bert");
	}
	
	@Test
	public void testAddBook() {
		this.testMap = new HashMap<Integer, Book>();
		this.id = 2;
		testBookService.addBook("testAddAuthor", "testAddTitle", "testAddGenre", "testAddYear");
		assertNotNull("ID not changed", testMap.get(id).getTitle());
		assertEquals("Book not added", testMap.get(id).getTitle(), "testAddTitle");
	}
	
	@Test
	public void testSearchGenre() {
		testBookService.initBookStore();
		testBookService.addBook("H. P. Lovecraft", "Call of Cthulu", "Horror, 1928");
		testBookService.addBook("Nicholas Sparks", "The Notebook", "Romance, 1996");
		Book[] horrorBooks = testBookService.searchGenre("Horror");
		assertEquals("Horror book 1 not found", horrorBooks[0].getAuthor(), "James Herbert");
		assertEquals("Horror book 2 not found", horrorBooks[1].getTitle(), "Call of Cthulu");
	}
	
}
