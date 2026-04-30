package com.turing.javaee8.jpamvc.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Movie extends BaseEntity{

	@Column
	String title;
	
	@Column
	Integer year;
	
	@Column
	String Genre;
	
	@OneToOne(mappedBy="movie",
			cascade = CascadeType.ALL)
	@ToString.Exclude //add this or remove @ToString from MovieDetails (stackOverFlow err)
	MovieDetails details;
}
