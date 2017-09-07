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
		assertNotNull("Map not initialised", testBookService.bookMap);
		assertEquals("Book 1 not added", testBookService.bookMap.get(1).getAuthor(), "James Herbert");
		assertEquals("Book 2 not added", testBookService.bookMap.get(2).getAuthor(), "Jim Bert");
	}
	
	@Test
	public void testAddBook() {
		testBookService.id=7;
		testBookService.addBook("testAddAuthor", "testAddTitle", "testAddGenre", "testAddYear");
		assertNotNull("ID not changed", testBookService.bookMap.get(testBookService.id).getGenre());
		assertEquals("Book not added", testBookService.bookMap.get(testBookService.id).getTitle(), "testAddTitle");
	}
	
	@Test
	public void testCountGenre() {
		testBookService.initBookStore();
		testBookService.addBook("H. P. Lovecraft", "Call of Cthulu", "Horror", "1928");
		testBookService.addBook("Nicholas Sparks", "The Notebook", "Romance", "1996");
		int count = testBookService.countGenre("Horror");
		assertEquals("Horror books count is incorrect", count, 2);
	}
	
}
