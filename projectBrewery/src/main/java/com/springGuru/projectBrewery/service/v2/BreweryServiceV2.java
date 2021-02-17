package com.springGuru.projectBrewery.service.v2;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.springGuru.projectBrewery.beans.v2.BeerStyleEnum;
import com.springGuru.projectBrewery.beans.v2.BreweryBeanV2;
@Service
public class BreweryServiceV2{
	public BreweryBeanV2 Fetch(UUID beerId) {
		return new BreweryBeanV2( OffsetDateTime.now(), OffsetDateTime.now(),beerId,"beer",2,BeerStyleEnum.GOSE);
	}

	public BreweryBeanV2 saveBeer(BreweryBeanV2 BreweryBeanV2) {
		return new BreweryBeanV2( OffsetDateTime.now(), OffsetDateTime.now(),UUID.randomUUID(),"beer",2,BeerStyleEnum.GOSE);
	}

	public BreweryBeanV2 updateBeer(UUID beerId, BreweryBeanV2 BreweryBeanV2) {
		// TODO Auto-generated method stub
		return new BreweryBeanV2( OffsetDateTime.now(), OffsetDateTime.now(),BreweryBeanV2.getBeerId(),BreweryBeanV2.getUpc(),BreweryBeanV2.getQuantityOnHand(),BeerStyleEnum.GOSE);
	}

	public BreweryBeanV2 DeleteBeer(UUID beerId) {
		// TODO Auto-generated method stub
		return null;
	}
}
