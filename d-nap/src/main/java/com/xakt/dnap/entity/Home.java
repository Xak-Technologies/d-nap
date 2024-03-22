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
public class Home {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long homeId;
	
	@Column(nullable=false)
	private Integer bedRooms;
	
	@Column(nullable=false)
	private Integer washRooms;
	
	@Column(nullable=false, length=15)
	private String paymentPartern;
	
	@Column(nullable=false)
	private Long price;
	
	@Column(nullable=false)
	private boolean parking;
	
	@Column(nullable=false)
	private boolean selfContained;
	
	@Column(nullable=false)
	private boolean diningRoom;
	
	@Column(nullable=false)
	private boolean livingRoom;
	
	@Column(nullable=false)
	private boolean kitchen;
	
	@Column(nullable=false)
	private boolean garage;
	
	@Column(nullable=false)
	private boolean swimmingPool;
	
	@Column(nullable=false)
	private boolean water;
	
	@Column(nullable=false)
	private boolean electricity;
	
	@Column(nullable=false)
	private boolean fenced;
	
	@Column(nullable=false)
	private boolean fullyFanished;	
	
	@CreationTimestamp
	@CreatedDate
	@Column(updatable=false)
	private Timestamp dateCreated;
	
	@UpdateTimestamp
	@LastModifiedDate
	private Timestamp lastUpdated;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="facility_id", referencedColumnName="facilityId")
	private Facility facility;

}
