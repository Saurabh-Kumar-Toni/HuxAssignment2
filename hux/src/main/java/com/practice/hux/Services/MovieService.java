package com.practice.hux.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.practice.hux.Entity.Movie;
import com.practice.hux.Repository.MovieRepository;

@Service
@Transactional
public class MovieService {

	@Autowired
	
	private MovieRepository movieRepository;
	
	

	public Movie saveMovieindb(Movie movie) {
		// TODO Auto-generated method stub
		return movieRepository.save(movie);
		
	}
}
