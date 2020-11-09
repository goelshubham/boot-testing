package com.boottesting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


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
public class IntegrationTest {

	@LocalServerPort
	private int port;
	
	private TestRestTemplate testRestTemplate = new TestRestTemplate();
	
	@Test
	public void integrationTest() throws Exception {
		
		String response = testRestTemplate.getForObject("http://localhost:" + port + "/get/hello", String.class);
		System.out.println(response);
		
	}
	
	
}
