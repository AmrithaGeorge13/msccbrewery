package com.springGuru.projectBrewery.controller.v2;

import java.util.UUID;

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

import com.springGuru.projectBrewery.beans.v2.BreweryBeanV2;
import com.springGuru.projectBrewery.service.v2.BreweryServiceV2;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/admin/V2/brewery")
public class BreweryControllerV2 {
	private BreweryServiceV2 BreweryService;

	@GetMapping(value="/{beerId}")
	public ResponseEntity<BreweryBeanV2> FetchResponse(@PathVariable UUID beerId){
		BreweryBeanV2 BreweryBeanV2=new BreweryBeanV2();
		BreweryBeanV2=BreweryService.Fetch(beerId);
		return new ResponseEntity<BreweryBeanV2>(BreweryBeanV2, HttpStatus.ACCEPTED);
	}
	@PostMapping
	public ResponseEntity saveBeer(@RequestBody BreweryBeanV2 BreweryBeanV2){
		log.debug("saveBeer method for post mapping start");
		BreweryBeanV2 BreweryBeanV2Obj=new BreweryBeanV2();
		BreweryBeanV2Obj=BreweryService.saveBeer(BreweryBeanV2);
		HttpHeaders header=new HttpHeaders();
		header.add("location","/admin/V1/brewery/"+BreweryBeanV2Obj.getBeerId());
		log.debug("saveBeer method for post mapping end");
		return new ResponseEntity<>(header, HttpStatus.CREATED);
	}
	@PutMapping(value="/{beerId}")
	public ResponseEntity updateBeer(@PathVariable UUID beerId,@RequestBody BreweryBeanV2 BreweryBeanV2){
		log.debug("updateBeer method for Put mapping start");
		BreweryBeanV2 BreweryBeanV2Obj=new BreweryBeanV2();
		BreweryBeanV2Obj=BreweryService.updateBeer(beerId,BreweryBeanV2);
		HttpHeaders header=new HttpHeaders();
		header.add("location","/admin/V1/brewery/"+BreweryBeanV2Obj.getBeerId());
		log.debug("updateBeer method for Put mapping end");
		return new ResponseEntity<>(header, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(value="/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void DeleteBeer(@PathVariable UUID beerId) {
		log.debug("DeleteBeer method for Delete mapping start");
		BreweryBeanV2 BreweryBeanV2Obj=new BreweryBeanV2();
		BreweryBeanV2Obj=BreweryService.DeleteBeer(beerId);
		log.debug("DeleteBeer method for Delete mapping end");
	}

}
