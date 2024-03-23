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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentalRoom {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long roomId;
	
	@Column(length=10, nullable=false)
	private String roomtNumber;
	
	@Column(length=15)
	private String floor;
	
	@Column(nullable=false)
	private Integer roomPrice;
	
	@Column(nullable=false, length=25)
	private String roomCategory;
	
	@Column(nullable=false)
	private boolean fullyFanished;
	
	@Column(nullable=false)
	private boolean kitchen;
	
	@Column(nullable=false)
	private boolean showerRoom;
	
	@Column(nullable=false)
	private boolean toilet; 
	
	@Column(nullable=false)
	private boolean storeRoom;
	
	@Column(nullable=false, updatable=false)
	@CreatedDate
	@CreationTimestamp
	private Timestamp dateCreated;
	
	@Column(nullable=false)
	@LastModifiedDate
	@UpdateTimestamp
	private Timestamp lastUpdated;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="rental_building_id", referencedColumnName="rentalBuildingId" )
	private RentalBuilding rentalBuilding;

}
