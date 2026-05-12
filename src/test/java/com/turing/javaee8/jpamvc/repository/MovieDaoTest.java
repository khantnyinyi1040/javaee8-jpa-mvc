package com.turing.javaee8.jpamvc.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.beans.factory.annotation.Autowired;

import com.turing.javaee8.jpamvc.model.Movie;
import com.turing.javaee8.jpamvc.model.MovieDetails;

import jakarta.transaction.Transactional;

import com.turing.javaee8.jpamvc.model.Actor;
import com.turing.javaee8.jpamvc.model.Comment;
import com.turing.javaee8.jpamvc.model.Director;

import lombok.extern.slf4j.Slf4j;

@Rollback(false)
@SpringBootTest
@Slf4j
public class MovieDaoTest {
	
	@Autowired
	MovieDao movieDao;
	
	@Autowired
	ActorDao actorDao;
	
	@Autowired
	DirectorDao directorDao;
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
	@Transactional
	//@Test
	public void testGetMovie() {
		Optional<Movie> result = this.movieDao.findById(1L);
		log.info("result"+result.get());
	}
	
	@Transactional
	//@Test
	public void testSaveComment() {
		Optional<Movie> result = this.movieDao.findById(1L);
		Movie movie = result.get();
		
		Comment c1 = new Comment();
		c1.setComment("comment 1");;	
		movie.getComment().add(c1);
		
		Comment c2=new Comment();
		c2.setComment("comment 2");;
		movie.getComment().add(c2);
		this.movieDao.save(movie);
		
	}
	@Transactional
	//@Test
	public void testDeleteComment() {
		Optional<Movie> result = this.movieDao.findById(1L);
		Movie movie = result.get();
		
		movie.getComment().remove(0);
		this.movieDao.save(movie);
	}
	@Transactional
	//@Test
	public void testUpdateComment() {
		Optional<Movie> result = this.movieDao.findById(1L);
		Movie movie = result.get();
		
		Comment comment = movie.getComment().get(0);
		comment.setComment("updated Comment!!!");
		this.movieDao.save(movie);
	}
	
	@Transactional
	//@Test
	public void testManyToMany() {
		Optional<Movie> result = this.movieDao.findById(1L);
		Movie movie = result.get();
		
		Optional<Actor> resultActor = this.actorDao.findById(2L);
		Actor actor = resultActor.get();
		
		movie.getActors().add(actor);
		this.movieDao.save(movie);
	}
	
	@Transactional
	@Test
	public void testManyToManyDirector() {
		Optional<Movie> result = this.movieDao.findById(1L);
		Movie movie = result.get();
		
		Optional<Director> resultDirector = this.directorDao.findById(1L);
		Director director = resultDirector.get();
		
		movie.getDirectors().add(director);
		this.movieDao.save(movie);
	}
	
}
