package com.xakt.dnap.entity;

import org.hibernate.validator.constraints.Length;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	@Column(nullable=false)
	@Length(max=50)
	private String country;
	
	@Column
	@Length(max=50)
	private String state;
	
	@Column(nullable=false)
	@Length(max=50)
	private String city;
	
	@Column
	@Length(max=50)
	private String county;
	
	@Column
	@Length(max=50)
	private String division;
	
	@Column
	@Length(max=50)
	private String parish;
	
	@Column(nullable=false)
	@Length(max=50)
	private String zone;
	
	@Column
	@Length(max=50)
	private String street;	
	
	@Column
	@Length(max=30)
	private String plotNumber;
}
