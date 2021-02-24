package com.springGuru.projectBrewery.controller;
import java.util.UUID;

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

import com.springGuru.projectBrewery.beans.BeerDto;
import com.springGuru.projectBrewery.service.BeerService;
import com.springGuru.projectBrewery.service.BreweryService;
import com.sun.net.httpserver.Headers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerControler {
private BeerService beerService;

@GetMapping("/{beerId}")
public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId){
	BeerDto beerDto=new BeerDto();
	beerDto=beerService.getBeerById(beerId);
	return new ResponseEntity<BeerDto>(beerDto,HttpStatus.ACCEPTED);
}

@PostMapping()
public ResponseEntity<BeerDto> saveNewBeer(@RequestBody BeerDto beerDto){
	BeerDto beerResult=new BeerDto();
	beerResult=beerService.saveBeer();
	Headers header=new Headers();
	header.add("location","/api/v1/beer/"+beerResult.getBeerId());
	return new ResponseEntity<BeerDto>(beerDto,HttpStatus.CREATED);
}


@PutMapping("/{beerId}")
public ResponseEntity<BeerDto> updateBeer(@PathVariable("beerId") UUID beerId,@RequestBody BeerDto beerDto){
	BeerDto beerResult=new BeerDto();
	beerResult=beerService.updateBeer(beerId,beerDto);
	Headers header=new Headers();
	header.add("location","/api/v1/beer/"+beerResult.getBeerId());
	return new ResponseEntity<BeerDto>(beerDto,HttpStatus.NO_CONTENT);
}

@DeleteMapping(value="/{beerId}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public  void deleteBeer(@PathVariable("beerId") UUID beerId){
	BeerDto beerResult=new BeerDto();
	beerService.deleteById(beerId);
}

}
