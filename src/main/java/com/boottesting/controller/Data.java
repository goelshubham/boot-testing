package com.boottesting.controller;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_compliance")
public class Data {
	
	@Id
	String id;

	String name;

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

	@Override
	public String toString() {
		return "Data [id=" + id + ", name=" + name + "]";
	}

	public Data(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Data() {
		// TODO Auto-generated constructor stub
	}

}
