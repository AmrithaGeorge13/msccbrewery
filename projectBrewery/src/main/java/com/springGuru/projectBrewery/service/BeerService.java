package com.springGuru.projectBrewery.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.springGuru.projectBrewery.beans.BeerDto;
import com.springGuru.projectBrewery.beans.v2.BeerStyleEnum;
import com.springGuru.projectBrewery.interfaces.BeerInterface;
@Service
public class BeerService implements BeerInterface{

	public BeerDto getBeerById(UUID beerId) {
		return  BeerDto.builder().beerId(beerId).pageSize(25).pageNumber(1).beerName("Amri").beerStyle(BeerStyleEnum.ALE).showInventoryOnHand(true).build();
	}

	public BeerDto saveBeer() {
		// TODO Auto-generated method stub
		return null;
	}

	public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteById(UUID beerId) {
		// TODO Auto-generated method stub
	}
	
}
