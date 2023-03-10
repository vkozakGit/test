package com.mycompany.test.controller;

import com.mycompany.test.dto.PersonData;
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

	@Autowired
	public MyController(@Qualifier("myPostgresqlService") PersonsDataService<PersonData> service) {
		this.service = service;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<PersonData>> myEndpointGet() {
		List<PersonData> allPosts = service.findAllPersons();
		return ResponseEntity.ok(allPosts);
	}


	@PutMapping("/putData")
	public ResponseEntity<Void> myEndpointPut(@RequestBody PersonData personData) {
		service.putPerson(personData);
		return ResponseEntity.noContent().build();
	}
}
