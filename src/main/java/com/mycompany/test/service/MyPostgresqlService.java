package com.mycompany.test.service;

import com.mycompany.test.dto.PersonData;
import com.mycompany.test.entity.PersonsSql;
import com.mycompany.test.repository.PersonSqlRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyPostgresqlService implements PersonsDataService<PersonData> {

	private final PersonSqlRepository repository;


	public MyPostgresqlService(PersonSqlRepository repository) {
		this.repository = repository;
	}


	@Override
	public void putPerson(PersonData personData) {
		PersonsSql personsSql = new PersonsSql(personData.name(), personData.surname());
		repository.save(personsSql);
	}


	@Override
	public List<PersonData> findAllPersons() {
		List<PersonsSql> allPersons = repository.findAll();
		return allPersons.stream()
				.map(p -> new PersonData(p.getName(), p.getSurname()))
				.collect(Collectors.toList());
	}
}
