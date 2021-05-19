package com.assignment.Controller;

import com.assignment.Model.Turnstile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Turnstiles {

    private static final String TOPIC = "turnstile";
    @Autowired
    KafkaTemplate<String, Turnstile> kafkaTemplate;

    @PostMapping("/addTurnstile")
    public String addTurnstile(@RequestBody Turnstile turnstile)
    {
        kafkaTemplate.send(TOPIC,turnstile);
        return "Turnstile Added successfully";
    }
}
