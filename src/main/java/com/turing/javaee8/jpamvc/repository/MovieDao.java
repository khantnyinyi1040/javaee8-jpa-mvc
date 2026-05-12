package com.turing.javaee8.jpamvc.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.turing.javaee8.jpamvc.model.dto.TitleAndYear;
import com.turing.javaee8.jpamvc.model.dto.TitleWithYear;
import com.turing.javaee8.jpamvc.model.Movie;

public interface MovieDao extends JpaRepository<Movie,Long>,JpaSpecificationExecutor<Movie> {

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
	
	@Query("select m from Movie m join details left join actors")
	List<Movie> testShowAllMoviesAndActors();
	
	@Query("select m.title AS title,m.year AS year from Movie m")
	List<TitleAndYear> getAllMoviesByTitleAndYear();
	
	@Query("select m.title AS title from Movie m")
	List<String> getAllMoviesByTitle();
	
	@Query("select m.title AS title,m.year as year from Movie m")
	List<TitleWithYear> getAllMoviesTitleWithYear();
	
	@Query("select m.details.details from Movie m join details")
	List<String> getMovieDetails();
	
	@Query("select m.title from Movie m where m.title like %:title%")
	List<String> findByTitleJPQL(String title);
	
	@Query("select m from Movie m left join actors act where act.firstName like %:firstName%")
	List<Movie> findByNameJPQL(String firstName);
	
	@Query("select m from Movie m left join actors act left join fetch directors where  act.firstName like %:firstName%")
	List<Movie> getAllMoviesLazy(String firstName);
	
	@Query("select count(m) from Movie m")
	Long getAllMoviesCount();
	
	@Query("select m.genre from Movie m  group by m.genre having count(m.genre) >= :genreCount")
	List<String> getGenre(Integer genreCount);
	
	@Query("select distinct m.genre from Movie m ")
	List<String> getAllGenre();
	
	@Query("select m.title from Movie m order by m.year ")
	List<String> getAllMovieOrderByYear();
	
	@Query("select m from Movie m limit :rowCount")
	List<Movie> getLimitMovie(Integer rowCount);
	
	@Query(value="select * from Movie ",nativeQuery=true)
	List<Movie> getAllMovieNative();
}
