package com.mycompany.test.service;

import com.mycompany.test.dto.PersonData;
import com.mycompany.test.entity.PersonsNosql;
import com.mycompany.test.repository.PersonsNosqlRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyMongoDbService implements PersonsDataService<PersonData>{

	private final PersonsNosqlRepository repository;

	public MyMongoDbService(PersonsNosqlRepository repository) {
		this.repository = repository;
	}


	@Override
	public void putPerson(PersonData personData) {
		PersonsNosql personsNosql = new PersonsNosql(personData.name(), personData.surname());
		repository.save(personsNosql);
	}


	@Override
	public List<PersonData> findAllPersons() {
		List<PersonsNosql> allPersons = repository.findAll();
		return allPersons.stream()
				.map(p -> new PersonData(p.getName(), p.getSurname()))
				.collect(Collectors.toList());

	}
}
