package com.assignment.Model;

public class Arrival {

    private String station_id;
    private String train_id;
    private String direction;
    private String line;
    private String train_status;
    private String prev_station_id;
    private String prev_direction;

    public Arrival(String station_id, String train_id, String direction, String line, String train_status, String prev_station_id, String prev_direction)
    {
        this.station_id = station_id;
        this.train_id = train_id;
        this.direction = direction;
        this.line = line;
        this.train_status = train_status;
        this.prev_station_id = prev_station_id;
        this.prev_direction = prev_direction;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public String getTrain_id() {
        return train_id;
    }

    public void setTrain_id(String train_id) {
        this.train_id = train_id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getTrain_status() {
        return train_status;
    }

    public void setTrain_status(String train_status) {
        this.train_status = train_status;
    }

    public String getPrev_station_id() {
        return prev_station_id;
    }

    public void setPrev_station_id(String prev_station_id) {
        this.prev_station_id = prev_station_id;
    }

    public String getPrev_direction() {
        return prev_direction;
    }

    public void setPrev_direction(String prev_direction) {
        this.prev_direction = prev_direction;
    }
}
