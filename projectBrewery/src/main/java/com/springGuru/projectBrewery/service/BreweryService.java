package com.springGuru.projectBrewery.service;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.springGuru.projectBrewery.beans.BreweryBean;

@Service
public class BreweryService {

	public BreweryBean Fetch(UUID beerId) {
		return new BreweryBean( OffsetDateTime.now(), OffsetDateTime.now(),beerId,"beer",2);
	}

	public BreweryBean saveBeer(BreweryBean breweryBean) {
		return new BreweryBean( OffsetDateTime.now(), OffsetDateTime.now(),UUID.randomUUID(),"beer",2);
	}

	public BreweryBean updateBeer(UUID beerId, BreweryBean breweryBean) {
		// TODO Auto-generated method stub
		return new BreweryBean( OffsetDateTime.now(), OffsetDateTime.now(),breweryBean.getBeerId(),breweryBean.getUpc(),breweryBean.getQuantityOnHand());
	}

	public BreweryBean DeleteBeer(UUID beerId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
