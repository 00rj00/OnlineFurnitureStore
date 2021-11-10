package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@WebAppConfiguration
public abstract class AbstractTest {
	protected MockMvc mvc;
	protected ObjectMapper objectMapper;

	@Autowired
	WebApplicationContext webApplicationContext;

	protected void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		objectMapper = new ObjectMapper();
	}

	protected String mapToJson(Object obj) throws Exception {
		setUp();
		return objectMapper.writeValueAsString(obj);
	}

	protected <T> T mapFromJson(String jsonStr, Class<T> clazz)
			throws Exception {
		setUp();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		return objectMapper.readValue(jsonStr, clazz);
	}

}
