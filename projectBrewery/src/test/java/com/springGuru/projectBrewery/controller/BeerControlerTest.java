package com.springGuru.projectBrewery.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springGuru.projectBrewery.beans.BeerDto;
import com.springGuru.projectBrewery.beans.v2.BeerStyleEnum;
import com.springGuru.projectBrewery.service.BeerService;

@WebMvcTest(BeerController.class)
class BeerControlerTest {

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	MockMvc mockmvc;

	@MockBean
	BeerService beerService;

	@Test
	public void getBeerById() throws Exception {
		mockmvc.perform(get("/api/v18/beer" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void saveNewBeer() throws Exception {
		BeerDto beerDto = BeerDto.builder().build();
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);
		//given(beerService.saveNewBeer(any())).willReturn(getValidBeerDto());
		mockmvc.perform((RequestBuilder) ((ResultActions) post("/api/v18/beer").contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJson))
				.andExpect(status().isCreated()));
	}

	@Test
	public void updateBeer() throws Exception {

	}

	@Test
	public void deleteBeer() throws Exception {
	}

	BeerDto getValidBeerDto() {
		return BeerDto.builder().beerName("My Beer").beerStyle(BeerStyleEnum.ALE).build();
	}
}
