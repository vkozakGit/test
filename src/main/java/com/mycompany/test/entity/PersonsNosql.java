package com.mycompany.test.entity;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "persons")
public class PersonsNosql {

	@Id
	private String id;
	private String name;
	private String surname;

	public PersonsNosql() {}

	public PersonsNosql(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}
}
