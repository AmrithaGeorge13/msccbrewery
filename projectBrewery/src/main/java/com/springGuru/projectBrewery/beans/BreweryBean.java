package com.springGuru.projectBrewery.beans;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BreweryBean {
	
	 	
		private OffsetDateTime createdDate;
	    private OffsetDateTime lastModifiedDate;
	    private UUID beerId;
	    private String upc;
	    private Integer quantityOnHand;
		public BreweryBean() {
			super();
			// TODO Auto-generated constructor stub
		}
		public BreweryBean(OffsetDateTime date, OffsetDateTime date2, UUID beerId2, String upc, int quantityOnHand) {
			this.createdDate=date;
			this.lastModifiedDate=date2;
			this.beerId=beerId2;
			this.upc=upc;
			this.quantityOnHand=quantityOnHand;
			
			// TODO Auto-generated constructor stub
		}
		public OffsetDateTime date2() {
			return createdDate;
		}
		public void setCreatedDate(OffsetDateTime createdDate) {
			this.createdDate = createdDate;
		}
		public OffsetDateTime getLastModifiedDate() {
			return lastModifiedDate;
		}
		public void setLastModifiedDate(OffsetDateTime lastModifiedDate) {
			this.lastModifiedDate = lastModifiedDate;
		}
		public UUID getBeerId() {
			return beerId;
		}
		public void setBeerId(UUID beerId) {
			this.beerId = beerId;
		}
		public String getUpc() {
			return upc;
		}
		public void setUpc(String upc) {
			this.upc = upc;
		}
		public Integer getQuantityOnHand() {
			return quantityOnHand;
		}
		public void setQuantityOnHand(Integer quantityOnHand) {
			this.quantityOnHand = quantityOnHand;
		}
		

}
