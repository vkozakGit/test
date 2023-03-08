package com.mycompany.test.service;

import com.mycompany.test.dto.DataDto;
import com.mycompany.test.entity.MyData;
import com.mycompany.test.repository.MyDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyMongoDbService {

	private final MyDataRepository myDataRepository;

	public MyMongoDbService(MyDataRepository myDataRepository) {
		this.myDataRepository = myDataRepository;
	}


	public void putData(DataDto dataDto) {
		MyData myData = new MyData(dataDto.name(), dataDto.id());
		myDataRepository.save(myData);
	}

	public List<MyData> findAll() {
		return myDataRepository.findAll();
	}
}
