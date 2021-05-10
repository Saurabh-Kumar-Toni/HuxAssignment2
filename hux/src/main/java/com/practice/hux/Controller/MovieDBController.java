package com.practice.hux.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.hux.Entity.Movie;
import com.practice.hux.Services.MovieService;
import com.practice.hux.Services.WriteToCSV;

@RestController
public class MovieDBController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private WriteToCSV writetocsv;
	
	@PostMapping(value = "/tvshows", params = "flag" )
	public void addMovie(@RequestBody Movie movie, @RequestParam String flag) throws IOException
	{
		long startTime = System.currentTimeMillis();
		if(flag.equals("db"))
			movieService.saveMovieindb(movie);
		if(flag.equals("csv"))
			writetocsv.writeToCSVfromRequestBody(movie);
		
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken in milliseconds is : " + (endTime-startTime) + "ms");
			
	}
	
	/*@PostMapping("/addCSV")
	public void addMovieCSV(@RequestBody Movie movie) throws IOException
	{
		writetocsv.writeToCSVfromRequestBody(movie);
	}*/

}
