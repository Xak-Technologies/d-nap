package com.xakt.dnap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
	
	@Column(nullable=false, length=20, unique=true)
	private String telephone1;
	
	@Column(nullable=true, length=20, unique=false)
	private String telephone2;
	
	@Column(nullable=false, length=50, unique=true)
	private String email;
	
	@Column(nullable=true, length=20, unique=true)
	private String fax;

}
