package com.example.bananesexport;


import com.example.bananesexport.model.Costumer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc

class BananesExportApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void contextLoads() {
	}

	/**
	 Consulter la liste des destinataires
	 */
	@Test
	public void getListCostumers() throws Exception {
		mockMvc.perform(get("/costumers"))
				.andExpect(jsonPath("$.length()", is(3)))
				.andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$.[0].name", is("name1")))
				.andExpect(jsonPath("$.[0].address", is("address1")))
				.andExpect(jsonPath("$.[0].zip_code", is("75001")))
				.andExpect(jsonPath("$.[0].city", is("city1")))
				.andExpect(jsonPath("$.[0].country", is("country1")))
				.andDo(print());
	}

	@Test
	public void registerCostumer() throws Exception {
		fail("Not yet implemented");

	}

	@Test
	public void getListCostumerPurchases(){
		fail("Not yet implemented");
	}


	@Test
	public void updateCostumer() {
		fail("Not yet implemented");
	}

	@Test
	public void deleteCostumer() {
		fail("Not yet implemented");
	}
	@Test
	public void registerPurchase() {
		fail("Not yet implemented");
	}
	@Test
	public void updatePurchase() {
		fail("Not yet implemented");
	}
	@Test
	public void deletePurchase() {
		fail("Not yet implemented");
	}
}
