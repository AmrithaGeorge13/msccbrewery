package com.springGuru.projectBrewery.interfaces;

import java.util.UUID;

import com.springGuru.projectBrewery.beans.CustomerBean;

public interface CustomerInterface {
	public CustomerBean CustomerServiceFetch(UUID customerUUID);
	public CustomerBean CustomerServiceSave(CustomerBean customerBean);
	public CustomerBean CustomerServiceUpdate(UUID customerId, CustomerBean customerBeanObj);
	public void CustomerServiceDelete(UUID customerId);
}
