package com.turing.javaee8.jpamvc.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.turing.javaee8.jpamvc.model.Book;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BookDaoTest {
	@Autowired
	BookDao bookDao;
	
	//@Test
	public void testGetAllBooks() {
		
		List<Book> books = this.bookDao.findAll();
		
		for(Book book: books) {
			log.info(""+book);
		}
		assertTrue(books.size()>0);
	}
	//@Test
	public void testFindById() {
		Optional<Book> book = this.bookDao.findById(1L);
		assertTrue(book.isPresent());
		 log.info(""+book.get());
	}
	//@Test
	public void testSaveBook() {
		Book book = new Book();
		book.setAuthor("Author 4");
		book.setTitle("Title 4");
		book.setYear(2019);
		this.bookDao.save(book);
		log.info(""+book);
	}
	//@Test
	public void testUpdateBook() {
		Optional<Book> result = this.bookDao.findById(13L);
		Book book = result.get();
		book.setYear(2017);
		this.bookDao.save(book);
	}
	//@Test
	public void testDeleteBook() {
		this.bookDao.deleteById(14L);
	}
}
