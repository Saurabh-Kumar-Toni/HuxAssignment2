package com.practice.hux.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.hux.Entity.Movie;
import com.practice.hux.Services.FilterMovieData;
import com.practice.hux.Utility.Reader;

@RestController
public class MovieController {
	
	@Autowired
	private static FilterMovieData filterMovieData;
	
	@GetMapping(value = "/tvshows", params = "count")
    public static List<Movie> getnTVShow(@RequestParam int count, HttpServletResponse response) throws FileNotFoundException, IOException, ParseException
    {
		long startTime = System.currentTimeMillis();
		List<Movie> result = new ArrayList<>();
		result = filterMovieData.filterByTypeTvShow(count);
		long endTime = System.currentTimeMillis();
	    
	    	//Adding the execution time in header
		response.setHeader("X-TIME-TO-EXECUTE",(endTime-startTime)+"ms");
        
        return result;
    }
	
	@GetMapping(value = "/tvshows", params = "movieType")
    public static List<Movie> getHorrorMovie(@RequestParam String movieType, HttpServletResponse response) throws FileNotFoundException, IOException, ParseException
    {
		long startTime = System.currentTimeMillis();
		List<Movie> result = new ArrayList<>();
		result = filterMovieData.findListedHorrorMovie(movieType);
		long endTime = System.currentTimeMillis();
		
	    //Adding the execution time in header
	    response.setHeader("X-TIME-TO-EXECUTE",(endTime-startTime)+"ms");
           return result;
    }
	
	@GetMapping(value = "/tvshows", params = "country")
    public static List<Movie> getCountryBasedMovie(@RequestParam String country, HttpServletResponse response) throws FileNotFoundException, IOException, ParseException
    {
		long startTime = System.currentTimeMillis();
		List<Movie> result = new ArrayList<>();
		result = filterMovieData.filterIndianMovie(country);
		long endTime = System.currentTimeMillis();
	    
	    	//Adding the execution time in header
		response.setHeader("X-TIME-TO-EXECUTE",(endTime-startTime)+"ms");
        return result;
        
    }
	
	@GetMapping(value = "/tvshows", params = {"startDate","endDate"})
    public static List<Movie> getDateBasedMovie(@RequestParam Date startDate, Date endDate, HttpServletResponse response) throws FileNotFoundException, IOException, ParseException
    {
		long startTime = System.currentTimeMillis();
		List<Movie> result = new ArrayList<>();
		result = filterMovieData.filterMovie(startDate,endDate);
		long endTime = System.currentTimeMillis();
	    	
	    	//Adding the execution time in header
		response.setHeader("X-TIME-TO-EXECUTE",(endTime-startTime)+"ms");
        return result;
    }
	
	

}
