package com.mycompany.test.entity;

//import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "my_collection")
public class MyData {
//	@Id
	private String id;
	private String name;
	private int age;

	public MyData() {}

	public MyData(String name, int age) {
		this.name = name;
		this.age = age;
	}


	public MyData(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
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


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
}
