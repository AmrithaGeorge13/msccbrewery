package com.springGuru.projectBrewery.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.springGuru.projectBrewery.beans.CustomerBean;

@Service
public class CustomerService {

	public CustomerBean CustomerServiceFetch(UUID customerUUID) {
		return  CustomerBean.builder().customerName("Amritha").customerUUID(customerUUID).build();
	}
}
