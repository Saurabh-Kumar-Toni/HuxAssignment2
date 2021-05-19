package com.assignment.Model;

public class Weather {

    private String temperature;
    private String status;

    public Weather(String temperature, String status) {
        this.temperature = temperature;
        this.status = status;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
