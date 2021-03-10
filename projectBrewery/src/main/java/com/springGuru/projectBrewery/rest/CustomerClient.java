package com.springGuru.projectBrewery.rest;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.springGuru.projectBrewery.beans.CustomerBean;
import com.springGuru.projectBrewery.beans.CustomerBean;
@Component
@ConfigurationProperties(value="code.easy.brewery",ignoreUnknownFields=false)
public class CustomerClient {
	private String apiHost;
	private final String CUSTOMER_PATH="/admin/V1/Customer";
	private final RestTemplate resttemplate;

	public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
		super();
		this.resttemplate = restTemplateBuilder.build();
	}

	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}

	public CustomerBean getCustomerById(UUID uuid) {
		return resttemplate.getForObject(apiHost+CUSTOMER_PATH+uuid.toString(), CustomerBean.class);
	}
	public URI saveCustomer(CustomerBean customerBean) {
		return resttemplate.postForLocation(apiHost+CUSTOMER_PATH, customerBean);
	}
	public void updateCustomer(UUID uuid,CustomerBean customerBean) {
		resttemplate.put(apiHost+CUSTOMER_PATH+uuid.toString(),customerBean);
	}
	public void deleteCustomer(UUID uuid) {
		resttemplate.delete(apiHost+CUSTOMER_PATH+uuid.toString());
	}//getForObject, postForLocation,Put,delete etc are methods available in RestTemplate
}
