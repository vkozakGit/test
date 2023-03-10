package com.mycompany.test.repository;

import com.mycompany.test.entity.PersonsNosql;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonsNosqlRepository extends MongoRepository<PersonsNosql, String> {
}
