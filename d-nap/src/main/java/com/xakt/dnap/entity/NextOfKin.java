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
public class NextOfKin {
	
	@Column(nullable=false, length=50)
	private String nokName;
	
	@Column(nullable=false, length=50)
	private String nokEmail;
	
	@Column(nullable=false, length=20)
	private String nokTelephone;
	
	@Column(nullable=false, length=30)
	private String nokNationalId;

}
