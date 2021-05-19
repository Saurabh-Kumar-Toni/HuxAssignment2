package com.assignment.Utils;

import com.assignment.Model.Station;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class ReadCSV {
    public String csvFileName = "data/stations.csv";
    public List stationList;

    public List ReadCSVFile()  {

        try {
            Reader csvReader = new BufferedReader(new FileReader(csvFileName));

            CsvToBean csvToBean = new CsvToBeanBuilder(csvReader)
                    .withType(Station.class)
                    .withIgnoreLeadingWhiteSpace(true).build();

            stationList = csvToBean.parse();

            csvReader.close();
        }catch(Exception FileNotFoundException){
            //e.printStackTrace();
            System.out.println("File is not available...");
        }

        return stationList;
    }
}
