package com.turing.javaee8.jpamvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.turing.javaee8.jpamvc.model.Movie;

public interface MovieDao extends JpaRepository<Movie,Long>{

	/*~~(class org.openrewrite.java.tree.J$Erroneous cannot be cast to class org.openrewrite.java.tree.J$Assignment (org.openrewrite.java.tree.J$Erroneous and org.openrewrite.java.tree.J$Assignment are in unnamed module of loader 'app'))~~>*/@Query("SELECT m FROM Movie m WHERE m.title = :title")
	List<Movie> findByTitle(String title);
	List<Movie> findByGenreAndYear(String genre,Integer year);
}
