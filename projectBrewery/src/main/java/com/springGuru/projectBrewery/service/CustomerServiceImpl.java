package com.springGuru.projectBrewery.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.springGuru.projectBrewery.beans.CustomerBean;
import com.springGuru.projectBrewery.interfaces.CustomerInterface;

@Service
public class CustomerServiceImpl implements CustomerInterface{

	@Override
	public CustomerBean CustomerServiceFetch(UUID customerUUID) {
		return  CustomerBean.builder().customerName("Amritha").customerUUID(customerUUID).build();
	}

	@Override
	public CustomerBean CustomerServiceSave(CustomerBean customerBean) {
		return  customerBean;
	}
	@Override
	public CustomerBean CustomerServiceUpdate(UUID customerId, CustomerBean customerBeanObj) {
		return  customerBeanObj;
	}
	@Override
	public void CustomerServiceDelete(UUID customerId) {
		// TODO Auto-generated method stub
	}
}
