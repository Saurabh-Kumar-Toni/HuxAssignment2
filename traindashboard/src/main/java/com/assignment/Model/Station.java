package com.assignment.Model;

import com.opencsv.bean.CsvBindByName;

public class Station {

    @CsvBindByName
    private String stop_id;

    @CsvBindByName
    private String direction_id;

    @CsvBindByName
    private String stop_name;

    @CsvBindByName
    private String station_name;

    @CsvBindByName
    private String station_descriptive_name;

    @CsvBindByName
    private int station_id;

    @CsvBindByName
    private String order;

    @CsvBindByName
    private Boolean red = false;

    @CsvBindByName
    private Boolean blue = false;

    @CsvBindByName
    private Boolean green = false;

    public String getStop_id() {
        return stop_id;
    }

    public void setStop_id(String stop_id) {
        this.stop_id = stop_id;
    }

    public String getDirection_id() {
        return direction_id;
    }

    public void setDirection_id(String direction_id) {
        this.direction_id = direction_id;
    }

    public String getStop_name() {
        return stop_name;
    }

    public void setStop_name(String stop_name) {
        this.stop_name = stop_name;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getStation_descriptive_name() {
        return station_descriptive_name;
    }

    public void setStation_descriptive_name(String station_descriptive_name) {
        this.station_descriptive_name = station_descriptive_name;
    }

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Boolean getRed() {
        return red;
    }

    public void setRed(Boolean red) {
        this.red = red;
    }

    public Boolean getBlue() {
        return blue;
    }

    public void setBlue(Boolean blue) {
        this.blue = blue;
    }

    public Boolean getGreen() {
        return green;
    }

    public void setGreen(Boolean green) {
        this.green = green;
    }
}
