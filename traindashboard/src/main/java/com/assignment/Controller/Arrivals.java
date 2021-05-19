package com.assignment.Controller;

import com.assignment.Model.Arrival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class Arrivals {

    @Autowired
    private KafkaTemplate<String, Arrival> kafkaTemplate;

    private static final String TOPIC = "arrivals";
    //station_id, train_id, direction, line, train_status, prev_station_id, prev_direction

    @PostMapping("/addArrival")
    public String AddArrival(@RequestBody Arrival arrival)
    {
        kafkaTemplate.send(TOPIC,arrival);
        return "Successfully sent the arrival to the topic";
    }

}
