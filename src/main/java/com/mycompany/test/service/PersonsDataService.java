package com.mycompany.test.service;

import java.util.List;

public interface PersonsDataService<T> {

	void putPerson(T t);

	List<T> findAllPersons();
}
