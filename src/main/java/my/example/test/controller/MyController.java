package my.example.test.controller;

import my.example.test.dto.DataDto;
import my.example.test.entity.Post;
import my.example.test.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class MyController {

	public final MyService myService;

	@Autowired
	public MyController(MyService myService) {
		this.myService = myService;
	}

	@GetMapping("/get")
	public ResponseEntity<List<Post>> myEndpointGet() {
		List<Post> allPosts = myService.findAllPosts();
		return ResponseEntity.ok(allPosts);
	}


	@PutMapping("/put")
	public ResponseEntity<Void> myEndpointPut(@RequestBody DataDto dataDto) {
		myService.createPost(dataDto);
		return ResponseEntity.noContent().build();
	}
}
