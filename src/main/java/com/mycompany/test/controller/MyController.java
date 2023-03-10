package com.mycompany.test.controller;

import com.mycompany.test.dto.PersonData;
import com.mycompany.test.kafka.KafkaProducer;
import com.mycompany.test.service.PersonsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class MyController {
	public final PersonsDataService<PersonData> service;
	public final KafkaProducer kafkaProducer;

	@Autowired
	public MyController(@Qualifier("myMongoDbService") PersonsDataService<PersonData> service,
						KafkaProducer kafkaProducer) {
		this.service = service;
		this.kafkaProducer = kafkaProducer;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<PersonData>> myEndpointGet() {
		List<PersonData> allPosts = service.findAllPersons();
		kafkaProducer.sendMessage("Get all data : " + allPosts.toString());
		return ResponseEntity.ok(allPosts);
	}


	@PutMapping("/putData")
	public ResponseEntity<Void> myEndpointPut(@RequestBody PersonData personData) {
		service.putPerson(personData);
		kafkaProducer.sendMessage("Put data : " + personData.toString());
		return ResponseEntity.noContent().build();
	}
}
