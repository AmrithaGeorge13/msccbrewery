package com.springGuru.projectBrewery.beans;

import java.time.OffsetDateTime;
import java.util.UUID;

import com.springGuru.projectBrewery.beans.v2.BeerStyleEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerBean {
	private UUID beerId;
	private Integer pageNumber;
	private Integer pageSize;
	private String beerName;
	private BeerStyleEnum  beerStyle;
	private Boolean showInventoryOnHand;
	private OffsetDateTime createdDate;
	private OffsetDateTime lastModifiedDate;
}
