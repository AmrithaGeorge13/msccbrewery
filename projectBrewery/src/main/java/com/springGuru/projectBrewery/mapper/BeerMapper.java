package com.springGuru.projectBrewery.mapper;

import org.mapstruct.Mapper;

import com.springGuru.projectBrewery.beans.BeerBean;
import com.springGuru.projectBrewery.beans.BeerDto;

@Mapper
public interface BeerMapper {

	BeerBean BeerDtoToBeerBean(BeerDto beerDto);
}
