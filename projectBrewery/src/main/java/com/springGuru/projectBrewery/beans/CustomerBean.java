package com.springGuru.projectBrewery.beans;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerBean {
private UUID customerUUID;
private String customerName;

}
