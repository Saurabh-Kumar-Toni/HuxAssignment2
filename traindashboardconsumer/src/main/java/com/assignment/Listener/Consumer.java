package com.assignment.Listener;

import com.assignment.Model.Turnstile;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

    @Service
    public class Consumer {
    @KafkaListener(topics = "turnstile",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(Turnstile turnstile) {
        System.out.println("Consumed JSON Message: " + turnstile.toString());

    }

}
