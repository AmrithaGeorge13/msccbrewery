package com.springGuru.projectBrewery.Repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springGuru.projectBrewery.Entity.BreweryEntity;

public interface BreweryRepository extends PagingAndSortingRepository<BreweryEntity, UUID> {

}
