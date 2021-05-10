package com.practice.hux.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.hux.Entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, String>{
	

}
