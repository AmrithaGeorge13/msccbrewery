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
	
}
