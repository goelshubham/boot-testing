package com.boottesting.controller;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositoryInterface extends CrudRepository<Data, String> {
	
}
