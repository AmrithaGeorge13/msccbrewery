package com.springGuru.projectBrewery.controller;

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
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.springGuru.projectBrewery.beans.CustomerBean;
import com.springGuru.projectBrewery.service.CustomerServiceImpl;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/admin/V1/Customer")
public class CustomerController {

	private CustomerServiceImpl customerService;
	
	@GetMapping("/{customerId}")
	private ResponseEntity<CustomerBean> GetCutsomer(@PathVariable UUID customerId){
		CustomerBean customerBean=new CustomerBean();
		customerBean=customerService.CustomerServiceFetch(customerId);
		return new ResponseEntity<CustomerBean>(customerBean, HttpStatus.ACCEPTED);
	}
	@PostMapping
	private ResponseEntity<CustomerBean> SaveCutsomer(@RequestBody CustomerBean customerBean){
		CustomerBean customerBeanObj=new CustomerBean();
		customerBeanObj=customerService.CustomerServiceSave(customerBeanObj);
		HttpHeaders header=new HttpHeaders();
		header.add("location","/admin/V1/Customer/"+customerBeanObj.getCustomerUUID());
		return new ResponseEntity<>(header, HttpStatus.NO_CONTENT);
	}
	@PutMapping
	private ResponseEntity UpdateCutsomer(@PathVariable UUID customerId,@RequestBody CustomerBean customerBean){
		CustomerBean customerBeanObj=new CustomerBean();
		customerBeanObj=customerService.CustomerServiceUpdate(customerId,customerBean);
		HttpHeaders header=new HttpHeaders();
		header.add("location","/admin/V1/Customer/"+customerBeanObj.getCustomerUUID());
		return new ResponseEntity<CustomerBean>(customerBean, HttpStatus.CREATED);
	}
	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	private void DeleteCutsomer(@PathVariable UUID customerId){
		customerService.CustomerServiceDelete(customerId);
		
	}
}
