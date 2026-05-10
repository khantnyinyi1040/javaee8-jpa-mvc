package com.turing.javaee8.jpamvc.repository.querymethod;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	//@Test
	public void testFindByGenreAndYear() {
		List<Movie> movies = this.movieDao.findByGenreAndYear("Horror",2023);
		movies.forEach(System.out::println);
	}
	@Transactional
	//@Test
	public void findByGenreOrderByYearDesc() {
		List<Movie> movies = this.movieDao.findByGenreOrderByYearDesc("Horror");
		movies.forEach(System.err::println);
	}
	
	//@Test
	@Transactional
	public void testPagination() {
		Pageable page = PageRequest.of(0, 5);
		Page<Movie> movies = this.movieDao.findAll(page);
		
		movies.forEach(System.err::println);
	}
	
	//@Test
	@Transactional
	public void testSort() {
		
		List<Movie> movies = this.movieDao.findAll(Sort.by("year").descending());
		
		movies.forEach(System.err::println);
	}
	//@Test
	@Transactional
	public void testFindByYearLessThan() {
		List<Movie> movies = this.movieDao.findByYearLessThan(2020);
		movies.forEach(System.err::println);
	}
	//@Test
	@Transactional
	public void testFindByYearAfter() {
		List<Movie> movies = this.movieDao.findByYearAfter(2020);
		movies.forEach(System.err::println);
	}
	//@Test
	@Transactional
	public void testFindByTitleLike() {
		List<Movie> movies = this.movieDao.findByTitleLike("%SuP%");
		movies.forEach(System.err::println);
	}
	
	//@Test
	@Transactional
	public void testFindByGenreNot() {
		List<Movie> movies = this.movieDao.findByGenreNot("Horror");
		movies.forEach(System.err::println);
	}
	//@Test
	@Transactional
	public void testFindByGenreIn() {
		List<String> genres = new ArrayList<>();
		genres.add("Horror");
		genres.add("Sci-fi");
		List<Movie> movies = this.movieDao.findByGenreIn(genres);
		movies.forEach(System.err::println);
	}
	//@Test
	@Transactional
	public void testJPQL() {
		Movie movie = this.movieDao.getMovieById(1L);
		System.err.print(""+movie);
	}
	//@Test
	@Transactional
	public void testJPQLNew() {
		List<Movie> movies = this.movieDao.getMovieByYear(2018);
		movies.forEach(System.err::println);
		}
	
	//@Test
	@Transactional
	public void testUpdateMovieGenreById() {
		
		int afftectedRow = this.movieDao.updateMovieGenreById("Action",18L);
		System.out.println("Row effected "+afftectedRow);
	}
	//@Test
	@Transactional
	public void testDeleteById() {
		
		int affectedRow = this.movieDao.deleteMovieById(18L);
		System.out.println(affectedRow);
	}
	//@Test
	@Transactional
	public void testInsertMovie() {
		
		int affectedRow = this.movieDao.insertMovie("Breaking Bad","Crime",2016);
		System.out.println(affectedRow);
	}
	
	@Test
	@Transactional
	public void testShowAllMovies() {
			
		List<Movie> movies= this.movieDao.showAllMovie();
		movies.forEach(System.err::println);
	}
}

