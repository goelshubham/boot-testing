package com.boottesting;

import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.boottesting.controller.Data;
import com.boottesting.controller.RepositoryInterface;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;


/*
  You could start the application and listen for a connection 
  (as it would do in production) and then send an HTTP request and assert the response.
	Note the use of webEnvironment=RANDOM_PORT to start the server with a random port 
	(useful to avoid conflicts in test environments) and the injection of the port 
	with @LocalServerPort. Also, note that Spring Boot has automatically provided a 
	TestRestTemplate for you.
*/
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureEmbeddedDatabase
public class IntegrationTest {

	@LocalServerPort
	private int port;
	
	@Value("${name}")
	private String name;
	
	private TestRestTemplate testRestTemplate = new TestRestTemplate();
	
	@Autowired
	private RepositoryInterface repo;
	
	@Before
	public void setUp() throws Exception {
		Data data = new Data("1", "Embedded Postgres");
		repo.save(data);		
	}
	
	@Test
	public void integrationTest() throws Exception {
		String response = testRestTemplate.getForObject("http://localhost:" + port + "/get/hello", String.class);
		System.out.println(response);		
	}
	
	
}
