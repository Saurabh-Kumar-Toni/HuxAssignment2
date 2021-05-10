package com.practice.hux;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.practice.hux.Entity.Movie;
import com.practice.hux.Repository.MovieRepository;
import com.practice.hux.Services.FilterMovieData;
import com.practice.hux.Services.MovieService;
import com.sun.el.stream.Stream;

@SpringBootTest
class HuxApplicationTests {

	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    Date date = new Date();
	@Test
	void contextLoads() {
	}
	
	@Autowired
	private MovieService movieservice;
	
	@MockBean
	private MovieRepository movierepository;
	
	@Test
	public void saveMovieindbTest() {
		Movie movie = new Movie("s9999","TV Show", "Test Show", "director2", "complete cast",
				"India", date, "2021", "U", "duration", "listed_in", "some desc");
		when(movierepository.save(movie)).thenReturn(movie);
		assertEquals(movie, movieservice.saveMovieindb(movie));
	}

}
