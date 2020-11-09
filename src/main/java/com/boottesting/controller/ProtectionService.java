package com.boottesting.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProtectionService {

	@Autowired
	private RepositoryInterface repo;
	
	public String getHello() {
		Optional<Data> optional = repo.findById("1");
		
		if(optional.isPresent()) {
			return optional.get().getName();
		}
		return "Data Not Found!!!";
	}
	
	
}
