package com.turing.javaee8.jpamvc.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.turing.javaee8.jpamvc.model.Movie;

public interface MovieDao extends JpaRepository<Movie,Long>{

	/*~~(class org.openrewrite.java.tree.J$Erroneous cannot be cast to class org.openrewrite.java.tree.J$Assignment (org.openrewrite.java.tree.J$Erroneous and org.openrewrite.java.tree.J$Assignment are in unnamed module of loader 'app'))~~>*/@Query("SELECT m FROM Movie m WHERE m.title = :title")
	List<Movie> findByTitle(String title);
	List<Movie> findByTitleLike(String title);
	List<Movie> findByGenreAndYear(String genre,Integer year);
	List<Movie> findByGenreOrderByYearDesc(String genre);
	List<Movie> findByYearLessThan(Integer year);
	List<Movie> findByYearAfter(Integer year);
	List<Movie> findByGenreNot(String genre);
	List<Movie> findByGenreIn(Collection<String> genre);
	
	@Query("select m from Movie m where m.id = ?1")
	Movie getMovieById(Long id);
	
	@Query("select m from Movie m where m.year=:year")
	List<Movie> getMovieByYear(Integer year);
	
	@Modifying
	@Query("update Movie m set m.genre = :genre where m.id = :id")
	int updateMovieGenreById(String genre,Long id);
	
	@Modifying
	@Query("delete Movie m  where m.id = :id")
	int deleteMovieById(Long id);
	
	@Modifying
	@Query("insert into Movie(title,genre,year) values(:title,:genre,:year)")
	int insertMovie(String title,String genre,Integer year);
	
	@Query("select m from Movie m")
	List<Movie> showAllMovie();
}
