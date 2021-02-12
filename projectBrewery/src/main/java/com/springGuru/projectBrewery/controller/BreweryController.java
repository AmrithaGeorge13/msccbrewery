package com.springGuru.projectBrewery.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springGuru.projectBrewery.beans.BreweryBean;
import com.springGuru.projectBrewery.service.BreweryService;

@RestController
@RequestMapping("/admin/V1/")
public class BreweryController {
	@Autowired
	private BreweryService BreweryService;

	@GetMapping(value="/brewery/{beerId}")
	public ResponseEntity<BreweryBean> FetchResponse(@PathVariable UUID beerId){
		BreweryBean breweryBean=new BreweryBean();
		breweryBean=BreweryService.Fetch(beerId);
		return new ResponseEntity<BreweryBean>(breweryBean, HttpStatus.ACCEPTED);
	}
	
}
