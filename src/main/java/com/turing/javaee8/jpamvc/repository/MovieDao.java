package com.turing.javaee8.jpamvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.turing.javaee8.jpamvc.model.Movie;

public interface MovieDao extends JpaRepository<Movie,Long>{

}
