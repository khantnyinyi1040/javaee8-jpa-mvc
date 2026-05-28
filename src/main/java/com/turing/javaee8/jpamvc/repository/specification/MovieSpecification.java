package com.turing.javaee8.jpamvc.repository.specification;
import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.domain.Specification;

import com.turing.javaee8.jpamvc.model.Actor;
import com.turing.javaee8.jpamvc.model.Director;
import com.turing.javaee8.jpamvc.model.Movie;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public  class MovieSpecification {
	//Root<T> root(Entitiy=> Movie), CriteriaQuery<?> query,CriteriaBuilder builder
		 public static Specification<Movie> getAllMovieInYear(long year) {
			    return (root, query, builder) -> {
			      return builder.equal(root.get("year"), year);
			    };
			   
}
		 public static Specification<Movie> getAllMovieInTitleYear(String title,Long year){
			 return (root,query,builder)-> {
				 List<Predicate> predicates = new ArrayList<>();
				 if(title != null && !title.isEmpty()) {
					 predicates.add(builder.equal(root.get("title"), title));
				 }
				 
				 if(year != null) {
					 predicates.add(builder.equal(root.get("year"),year ));
				 }
				 return builder.or(predicates);
			 };
		 }

	 
		 public static Specification<Movie> getAllMovieWithActorIn(String actor) {
				return (root,query,cb) -> {
					Join<Movie, Actor> actors = root.join("actors");
					return cb.like(actors.get("fullName"), "%"+actor+"%");
					
				};
			};  public static Specification<Movie> getAllMovieWithActorOrDirector(String actor,String director) {
				return (root,query,cb) -> {
					Join<Movie, Actor> actors = root.join("actors",JoinType.LEFT);
					Join<Movie,Director> directors = root.join("directors",JoinType.LEFT);
					return cb.or(
							cb.like(actors.get("fullName"), "%"+actor+"%"),
							cb.like(directors.get("fullName"),"%"+director+"%"));
					
				};
			};  
}