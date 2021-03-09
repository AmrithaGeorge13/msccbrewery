x`package com.springGuru.projectBrewery.config;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.springGuru.projectBrewery.beans.BeerDto;

class BreweryClientTest {
	@Autowired
	BreweryClient  breweryClient;
	@Test
	void getBeerByIdTest() {
		BeerDto dto=breweryClient.getBeerById(UUID.randomUUID());
		assertNotNull(dto);
	}
	@Test
	void saveBeerTest() {
		BeerDto dto=breweryClient.getBeerById(UUID.randomUUID());
		URI uri=breweryClient.saveBeerDto(dto);
		assertNotNull(uri);
		System.out.println(uri.toString());
	}
	@Test
	void updateBeerTest() {
		BeerDto beerdto=BeerDto.builder().beerName("Beer New").build();
		breweryClient.updateBeer(UUID.randomUUID(),beerdto);
	}
}
