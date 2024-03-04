package com.xakt.dnap.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Facility {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long facilityId;
	
	@Column(name="facility_category", nullable=false)
	@NotBlank(message="Please add facility category")
	private String facilityCategory;
	
	@Column(name="facility_name")
	private String facilityName;
	
	@CreatedDate
	@CreationTimestamp
	@Column(name="date_created", updatable=false)
	private Timestamp dateCreated;
	
	@LastModifiedDate
	@UpdateTimestamp
	@Column(name="last_updated")
	private Timestamp lastUpdated;

}
