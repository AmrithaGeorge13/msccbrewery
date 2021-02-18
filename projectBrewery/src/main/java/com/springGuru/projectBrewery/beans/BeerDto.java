package com.springGuru.projectBrewery.beans;

import java.util.UUID;

import com.springGuru.projectBrewery.beans.v2.BeerStyleEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
	private UUID beerId;
	private Integer pageNumber;
	private Integer pageSize;
	private String beerName;
	private BeerStyleEnum  beerStyle;
	private Boolean showInventoryOnHand;
}
