package com.springGuru.projectBrewery.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springGuru.projectBrewery.beans.CustomerBean;
import com.springGuru.projectBrewery.service.CustomerService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/admin/V1/")
public class CustomerController {

	private CustomerService customerService;
	
	@RequestMapping("Customer/{customerId}")
	private ResponseEntity<CustomerBean> GetCutsomer(@PathVariable UUID customerId){
		CustomerBean customerBean=new CustomerBean();
		customerBean=customerService.CustomerServiceFetch(customerId);
		return new ResponseEntity<CustomerBean>(customerBean, HttpStatus.ACCEPTED);
	}
	
}
