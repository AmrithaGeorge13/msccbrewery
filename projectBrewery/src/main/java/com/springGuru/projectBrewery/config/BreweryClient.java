package com.springGuru.projectBrewery.config;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.springGuru.projectBrewery.beans.BeerDto;

@Component
@ConfigurationProperties(value="code.easy.brewery",ignoreUnknownFields=false)
public class BreweryClient {
private String apiHost;
private final String BEER_PATH="/api/v1/beer/";
private final RestTemplate resttemplate;

public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
	super();
	this.resttemplate = restTemplateBuilder.build();
}

public void setApiHost(String apiHost) {
	this.apiHost = apiHost;
}

public BeerDto getBeerById(UUID uuid) {
	return resttemplate.getForObject(apiHost+BEER_PATH+uuid.toString(), BeerDto.class);
}
public URI saveBeerDto(BeerDto beerdto) {
	return resttemplate.postForLocation(apiHost+BEER_PATH, beerdto);
}
public void updateBeer(UUID uuid,BeerDto beerdto) {
	resttemplate.put(apiHost+BEER_PATH+uuid.toString(),beerdto);
}
}
