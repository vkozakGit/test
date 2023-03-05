package my.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MyController {

	public final MyService myService;

	@Autowired
	public MyController(MyService myService) {
		this.myService = myService;
	}

	@GetMapping("/get")
	public ResponseEntity<DataDto> myEndpoint() {
		DataDto dataDto = myService.initData();
		return ResponseEntity.ok(dataDto);
	}
}
