package com.assignment.traindashboardconsumer;

import com.assignment.Deserializer.JSONDeserializer;
import com.assignment.Model.Turnstile;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Properties;

@SpringBootApplication(scanBasePackages = {"com.assignment.Config","com.assignment.Listener"
		,"com.assignment.Model","com.assignment.traindashboardconsumer"})
public class TraindashboardconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraindashboardconsumerApplication.class, args);
	}

}
