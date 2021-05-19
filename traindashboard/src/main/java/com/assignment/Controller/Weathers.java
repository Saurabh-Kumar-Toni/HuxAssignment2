package com.assignment.Controller;


import com.assignment.Model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Weathers {

    private static final String TOPIC = "weather";
    @Autowired
    KafkaTemplate<String, Weather> kafkaTemplate;

    @PostMapping("/addWeather")
    public String addWeather(@RequestBody Weather weather)
    {
        kafkaTemplate.send(TOPIC, weather);
        return "Turnstile Added successfully";
    }
}
