package com.springGuru.projectBrewery.Entity;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BreweryEntity {
@Id
@GeneratedValue(generator="UUID")
@GenericGenerator(name="UUID",strategy="org.hibernate.id.UUIDGenerator")
@Column(length=36,columnDefinition="varchar",updatable=false,nullable=false)
private  UUID uuid;
@Version
private Long version;
@CreationTimestamp
private Timestamp createDate;
@UpdateTimestamp
private Timestamp modifiedDate;
private String beerName;
private String beerStyle;
}
