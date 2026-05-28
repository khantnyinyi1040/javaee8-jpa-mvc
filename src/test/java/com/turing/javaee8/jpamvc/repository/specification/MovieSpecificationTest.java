package com.turing.javaee8.jpamvc.repository.specification;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.turing.javaee8.jpamvc.model.Movie;
import com.turing.javaee8.jpamvc.repository.MovieDao;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Rollback(false)
@SpringBootTest
@Slf4j
public class MovieSpecificationTest {
	@Autowired
	MovieDao movieDao;
	@Test
	@Transactional
	public void testSpecification() {
		//List<Movie> movies = movieDao.findAll(MovieSpecification.getAllMovieInYear(2026));
		//List<Movie> movies = movieDao.findAll(MovieSpecification.getAllMovieInTitleYear("Conjuring",2016L));
		//List<Movie> movies = movieDao.findAll(MovieSpecification.getAllMovieWithActorIn("Sai"));
		List<Movie> movies = movieDao.findAll(MovieSpecification.getAllMovieWithActorOrDirector("Sai","Aye"));
		movies.forEach(System.err::println);
	}
}
