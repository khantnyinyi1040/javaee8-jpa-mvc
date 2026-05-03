package com.turing.javaee8.jpamvc.repository.querymethod;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.turing.javaee8.jpamvc.model.Movie;
import com.turing.javaee8.jpamvc.repository.MovieDao;
import com.turing.javaee8.jpamvc.repository.MovieDaoTest;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Rollback(false)
@SpringBootTest
@Slf4j
public class MovieQueryTest {
	
	@Autowired
	MovieDao movieDao;
	@Transactional
	//@Test
	public void testFindByTitle() {
		List<Movie> movies = this.movieDao.findByTitle("Goat");
		movies.forEach(System.out::println);
	}
	@Transactional
	@Test
	public void testFindByGenreAndYear() {
		List<Movie> movies = this.movieDao.findByGenreAndYear("Horror",2023);
		movies.forEach(System.out::println);
	}
	
}
