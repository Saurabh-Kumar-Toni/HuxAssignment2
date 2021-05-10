package com.practice.hux.Services;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.practice.hux.Entity.Movie;
import com.practice.hux.Utility.Reader;



import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class FilterMovieData {

	
    public List<Movie> showAll() throws IOException, ParseException {
        List<Movie> result = new ArrayList<>();
        result = Reader.ParseCSVandRead();
		return result;
    }

	
    public static List<Movie> filterByTypeTvShow(int count) throws FileNotFoundException, IOException, ParseException
    {
    	List<Movie> movie = new ArrayList<>();
    	movie = Reader.ParseCSVandRead();
    	List<Movie> result = new ArrayList<>();
        result = movie.stream().filter(m -> m.getDate_added() != null)
                .filter(m -> m.getType().equals("TV Show")).limit(count)
                .collect(Collectors.toList());
        return result;
    }

    public static List<Movie> findListedHorrorMovie(String movieType) throws FileNotFoundException, IOException, ParseException
    {
    	List<Movie> movie = new ArrayList<>();
    	movie = Reader.ParseCSVandRead();
    	List<Movie> result = new ArrayList<>();
        result = movie.stream().filter(m -> m.getDate_added() != null)
                .filter(m -> m.getListed_in().contains(movieType))
                .collect(Collectors.toList());
        return result;
    }

    public static List<Movie> filterIndianMovie(String country) throws FileNotFoundException, IOException, ParseException
    {
    	List<Movie> movie = new ArrayList<>();
    	movie = Reader.ParseCSVandRead();
    	List<Movie> result = new ArrayList<>();
        result = movie.stream().filter(m -> m.getDate_added() != null)
                .filter(m -> m.getCountry().contains(country))
                .collect(Collectors.toList());
        
        return result;
    }
    
    public static List<Movie> filterMovie(Date startDate, Date endDate) throws FileNotFoundException, IOException, ParseException
    {
    	List<Movie> movie = new ArrayList<>();
    	movie = Reader.ParseCSVandRead();
    	List<Movie> result = new ArrayList<>();
        result = movie.stream().filter(m -> m.getDate_added() != null)
                .filter(m -> m.getDate_added().after(startDate) && m.getDate_added().before(endDate))
                .collect(Collectors.toList());
        return result;
    }
}
