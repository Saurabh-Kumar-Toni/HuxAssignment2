package com.practice.hux.Utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.util.ResourceUtils;

import com.practice.hux.Entity.Movie;


public class Reader {

	public static List<Movie> ParseCSVandRead() throws FileNotFoundException, IOException, ParseException {
        File file = ResourceUtils.getFile("classpath:netflix_titles.csv");
        BufferedReader fileReader = null;


        //Delimiter used in CSV file
        final String DELIMITER = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
        List<Movie> MovieList = new ArrayList<>();


        String line = "";
        fileReader = new BufferedReader(new FileReader(file));
        int count = 0;
        //Read the file line by line
        while ((line = fileReader.readLine()) != null) {
            //Get all tokens available in line
            line.trim();
            String[] tokens = line.split(DELIMITER);
            if(count == 0)
            {
                count++;
                continue;
            }
            String show_id = tokens[0];
            String type = tokens[1];
            String title = tokens[2];
            String director = tokens[3];
            String cast = tokens[4];
            String country = tokens[5];
            String release_year = tokens[7];
            String rating = tokens[8];
            String duration = tokens[9];
            String listed_in = tokens[10];
            String description = tokens[11];
            //System.out.println("id is = " + tokens[0]);
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            Date date;
            date = !tokens[6].isEmpty() ? format.parse(tokens[6].replaceAll("\"","").trim()) : null;

            Movie movie = new Movie(show_id, type, title, director, cast, country,
                    date,release_year,rating, duration, listed_in,description);
            MovieList.add(movie);


        }
        return MovieList;
    }
}
