package com.practice.hux.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public static List<Movie> getnTVShow(@RequestParam int count) throws FileNotFoundException, IOException, ParseException
    {
		
        return filterMovieData.filterByTypeTvShow(count);
    }
	
	@GetMapping(value = "/tvshows", params = "movieType")
    public static List<Movie> getHorrorMovie(@RequestParam String movieType) throws FileNotFoundException, IOException, ParseException
    {
 
        return filterMovieData.findListedHorrorMovie(movieType);
    }
	
	@GetMapping(value = "/tvshows", params = "country")
    public static List<Movie> getCountryBasedMovie(@RequestParam String country) throws FileNotFoundException, IOException, ParseException
    {
 
        return filterMovieData.filterIndianMovie(country);
    }
	
	@GetMapping(value = "/tvshows", params = {"startDate","endDate"})
    public static List<Movie> getDateBasedMovie(@RequestParam Date startDate, Date endDate) throws FileNotFoundException, IOException, ParseException
    {
 
        return filterMovieData.filterMovie(startDate,endDate);
    }
	
	

}
