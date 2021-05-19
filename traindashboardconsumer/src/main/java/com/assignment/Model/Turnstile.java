package com.assignment.Model;

//Model Class for Turnstile
public class Turnstile {

    //station_id, station_name, line

    private String station_id;
    private String station_name;
    private String line;

    @Override
    public String toString() {
        return "Turnstile{" +
                "station_id='" + station_id + '\'' +
                ", station_name='" + station_name + '\'' +
                ", line='" + line + '\'' +
                '}';
    }

    //Default Constructor
    public Turnstile() {
    }

    //Parameterized Constructor
    public Turnstile(String station_id, String station_name, String line) {
        this.station_id = station_id;
        this.station_name = station_name;
        this.line = line;
    }

    //Getters and Setters started
    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }


}

