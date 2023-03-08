package com.mycompany.test.controller;

import com.mycompany.test.dto.DataDto;
import com.mycompany.test.entity.MyData;
import com.mycompany.test.service.MyMongoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class MyController {
	public final MyMongoDbService myMongoDbService;

	@Autowired
	public MyController(MyMongoDbService myMongoDbService) {
		this.myMongoDbService = myMongoDbService;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<MyData>> myEndpointGet() {
		List<MyData> allPosts = myMongoDbService.findAll();
		return ResponseEntity.ok(allPosts);
	}


	@PutMapping("/putData")
	public ResponseEntity<Void> myEndpointPut(@RequestBody DataDto dataDto) {
		myMongoDbService.putData(dataDto);
		return ResponseEntity.noContent().build();
	}
}
