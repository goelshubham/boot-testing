package com.boottesting;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/*
 * Another useful approach is to not start the server at all but to test only the layer below that, 
 * where Spring handles the incoming HTTP request and hands it off to your controller. 
 * That way, almost of the full stack is used, and your code will be called in exactly 
 * the same way as if it were processing a real HTTP request but without the cost of 
 * starting the server. To do that, use Spring’s MockMvc and ask for that to be injected 
 * for you by using the @AutoConfigureMockMvc annotation on the test case.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest2 {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void controllerTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get("/get/hello")	
				.accept(MediaType.ALL_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}
	
}
