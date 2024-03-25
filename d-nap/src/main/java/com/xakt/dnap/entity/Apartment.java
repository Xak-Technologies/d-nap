package com.xakt.dnap.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Apartment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long apartmentId;
	
	@Column(length=10, nullable=false)
	private String apartmentNumber;
	
	@Column(length=15)
	private String floor;
	
	@Column(nullable=false)
	private Integer apartmentPrice;
	
	@Column(nullable=false)
	private Integer bedrooms;
	
	@Column(nullable=false)
	private boolean fullyFanished;
	
	@Column(nullable=false)
	private boolean livingRoom;
	
	@Column(nullable=false)
	private boolean kitchen;
	
	@Column(nullable=false)
	private boolean showerRoom;
	
	@Column(nullable=false)
	private boolean toilet;
	
	@Column(nullable=false)
	private boolean laundryRoom;
	
	@Column(nullable=false)
	private boolean storeRoom;
	
	@Column(nullable=false)
	private boolean diningRoom;
	
	@Column(nullable=false, updatable=false)
	@CreatedDate
	@CreationTimestamp
	private Timestamp dateCreated;
	
	@Column(nullable=false)
	@LastModifiedDate
	@UpdateTimestamp
	private Timestamp lastUpdated;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="apartment_building_id", referencedColumnName="apartmentBuildingId" )
	private ApartmentBuilding apartmentBuilding;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tenant_id", referencedColumnName="tenantId")
	private Tenant tenant;

}
