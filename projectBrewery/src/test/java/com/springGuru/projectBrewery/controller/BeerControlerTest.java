package com.springGuru.projectBrewery.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import javax.net.ssl.SSLEngineResult.Status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.springGuru.projectBrewery.beans.BeerDto;
@WebMvcTest(BeerController.class)
class BeerControlerTest {
	
@Autowired
MockMvc mockmvc;
	
@Test
public void getBeerById( UUID beerId) throws Exception{
	mockmvc.perform(get("/api/v1/beer"+UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
}

@Test
public void saveNewBeer(BeerDto beerDto){
	
}


@Test
public void updateBeer(UUID beerId,BeerDto beerDto){
	
}

	@Test
public  void deleteBeer(UUID beerId){
}

}
