package com.springGuru.projectBrewery.beans;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
public class BeerPageList extends PageImpl<BeerDto>{

	public BeerPageList(List<BeerDto> content, Pageable pageable, long total) {
		super(content, pageable, total);
		// TODO Auto-generated constructor stub
	}

	public BeerPageList(List<BeerDto> content) {
		super(content);
		// TODO Auto-generated constructor stub
	}

}
