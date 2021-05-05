package com.springGuru.projectBrewery.beans;

import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerBean {
@NotNull
private UUID customerUUID;

@Size(min = 3,max = 100)
private String customerName;

}
