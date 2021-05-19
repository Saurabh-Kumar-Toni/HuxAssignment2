package com.assignment.traindashboard;

import com.assignment.Model.Station;
import com.assignment.Serializer.JsonSerializer;
import com.assignment.Utils.ReadCSV;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Properties;

//@ComponentScan(basePackages = {"com.assignment.Model","com.assignment.Serializer"
//		,"com.assignment.Services"})

@SpringBootApplication(scanBasePackages = {"com.assignment.Model","com.assignment.Serializer"
,"com.assignment.Controller","com.assignment.Configuration", "com.assignment.Stream"})
public class TraindashboardApplication {

	public static void main(String[] args) {

		SpringApplication.run(TraindashboardApplication.class, args);

		Properties props = new Properties();
		//props.put(ProducerConfig.CLIENT_ID_CONFIG,"stations");
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);




		KafkaProducer<String,Station> producer = new KafkaProducer<String,Station>(props);

		ReadCSV readCSV = new ReadCSV();
		List stationList = readCSV.ReadCSVFile(); //It will return the student list
		for (Object stationObject : stationList) {
			Station station = (Station) stationObject;
			producer.send(new ProducerRecord<String, Station>("stations",station.getStop_id(),station));
		}

		producer.close();
	}

}
