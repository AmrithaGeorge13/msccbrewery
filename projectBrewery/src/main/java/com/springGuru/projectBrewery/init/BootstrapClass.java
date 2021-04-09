package com.springGuru.projectBrewery.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.springGuru.projectBrewery.Entity.BreweryEntity;
import com.springGuru.projectBrewery.Repository.BreweryRepository;

public class BootstrapClass implements CommandLineRunner {
	@Autowired
	private BreweryRepository breweryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		loaderObject();
	}

	private void loaderObject() {
		if(breweryRepository.count()==0) {
			breweryRepository.save(BreweryEntity.builder()
					.beerName("RootBeer")
					.build());
		}
		
	}

}
