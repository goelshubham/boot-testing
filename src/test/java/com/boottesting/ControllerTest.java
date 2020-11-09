package com.boottesting;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.boottesting.controller.Controller;
import com.boottesting.controller.ProtectionService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = Controller.class)
public class ControllerTest {

	/*
	 * MockMvc can only be used to do Unit Testing of web layer (Controller class)
	 * It cannot be used for integration testing
	 */

	@Autowired
	private MockMvc mvc;

	@MockBean
	ProtectionService protectionService;
	
	@Test
	public void testGetHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/get/hello")	
				.accept(MediaType.ALL_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}	
}
