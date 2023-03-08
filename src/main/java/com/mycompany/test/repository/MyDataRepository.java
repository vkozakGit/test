package com.mycompany.test.repository;

import com.mycompany.test.entity.MyData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyDataRepository extends MongoRepository<MyData, String> {
}
