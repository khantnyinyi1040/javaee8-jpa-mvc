package com.turing.javaee8.jpamvc.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.turing.javaee8.jpamvc.model.Movie;
import com.turing.javaee8.jpamvc.model.MovieDetails;

import lombok.extern.slf4j.Slf4j;


@SpringBootTest
@Slf4j
public class MovieDaoTest {
	
	@Autowired
	MovieDao movieDao;
	//@Test
	public void testSaveMovie() {
		Movie movie = new Movie();
		movie.setTitle("Goat");
		movie.setYear(2026);
		movie.setGenre("Comedy");
		
		MovieDetails details = new MovieDetails();
		details.setDetails("A Good Flim!!!");
		
		movie.setDetails(details);
		details.setMovie(movie);
				
		this.movieDao.save(movie);
	}
	@Test
	public void testGetMovie() {
		Optional<Movie> result = this.movieDao.findById(1L);
		log.info("result"+result.get());
	}
}
