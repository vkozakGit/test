package my.example.test;

import org.springframework.stereotype.Service;

@Service
public class MyService {

	public DataDto initData() {
		return new DataDto("Vitali", 28);
	}
}
