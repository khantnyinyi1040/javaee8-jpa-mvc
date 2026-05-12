package com.turing.javaee8.jpamvc.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
public class Director extends Human{
	Address address;
	
	@ToString.Exclude
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, 
			cascade= {
					CascadeType.MERGE,
					CascadeType.PERSIST
			}, 
				mappedBy = "directors")
	private Set<Movie> movies = new HashSet<Movie>();
}
