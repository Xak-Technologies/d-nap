package com.xakt.dnap.entity;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
	@Length(max=50, min=3)
	private String facilityCategory;
	
	@Column(name="facility_name")
	@Length(max=50, min=3)
	private String facilityName;
	
	@Embedded 
	private Address facilityLocation;
	
	@CreatedDate
	@CreationTimestamp
	@Column(name="date_created", updatable=false)
	private Timestamp dateCreated;
	
	@LastModifiedDate
	@UpdateTimestamp
	@Column(name="last_updated")
	private Timestamp lastUpdated;	
	
	
	@ManyToMany(mappedBy = "facilities")
    private List<Tenant> tenants;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="landlord_id", referencedColumnName="landlordId", nullable=false)
	private Landlord landlord;
}
