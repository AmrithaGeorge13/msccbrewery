package com.springGuru.projectBrewery.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springGuru.projectBrewery.beans.BreweryBean;
import com.springGuru.projectBrewery.service.BreweryService;
import com.springGuru.projectBrewery.service.CustomerServiceImpl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/admin/V1//brewery")
public class BreweryController {
	private BreweryService BreweryService;

	@GetMapping(value="/{beerId}")
	public ResponseEntity<BreweryBean> FetchResponse(@PathVariable UUID beerId){
		BreweryBean breweryBean=new BreweryBean();
		breweryBean=BreweryService.Fetch(beerId);
		return new ResponseEntity<BreweryBean>(breweryBean, HttpStatus.ACCEPTED);
	}
	@PostMapping
	public ResponseEntity saveBeer(@RequestBody BreweryBean breweryBean){
		log.debug("saveBeer method for post mapping start");
		BreweryBean breweryBeanObj=new BreweryBean();
		breweryBeanObj=BreweryService.saveBeer(breweryBean);
		HttpHeaders header=new HttpHeaders();
		header.add("location","/admin/V1/brewery/"+breweryBeanObj.getBeerId());
		log.debug("saveBeer method for post mapping end");
		return new ResponseEntity<>(header, HttpStatus.CREATED);
	}
	@PutMapping(value="/{beerId}")
	public ResponseEntity updateBeer(@PathVariable UUID beerId,@RequestBody BreweryBean breweryBean){
		log.debug("updateBeer method for Put mapping start");
		BreweryBean breweryBeanObj=new BreweryBean();
		breweryBeanObj=BreweryService.updateBeer(beerId,breweryBean);
		HttpHeaders header=new HttpHeaders();
		header.add("location","/admin/V1/brewery/"+breweryBeanObj.getBeerId());
		log.debug("updateBeer method for Put mapping end");
		return new ResponseEntity<>(header, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(value="/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void DeleteBeer(@PathVariable UUID beerId) {
		log.debug("DeleteBeer method for Delete mapping start");
		BreweryBean breweryBeanObj=new BreweryBean();
		breweryBeanObj=BreweryService.DeleteBeer(beerId);
		log.debug("DeleteBeer method for Delete mapping end");
	}
	
}
