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
public class Motel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long motelId;
	
	@Column(nullable=false)
	private boolean airportPickup;
	
	@Column(nullable=false)
	private boolean gym;
	
	@Column(nullable=false)
	private boolean conferenceSpace;
	
	@Column(nullable=false)
	private boolean freeBreakFast;
	
	@Column(nullable=false)
	private boolean meetingSpace;
	
	@Column(nullable=false)
	private boolean eventsSpace;
	
	@Column(nullable=false)
	private boolean swimingPool;
	
	@Column(nullable=false)
	private boolean restaurant;
	
	@Column(nullable=false)
	private boolean parking;
	
	@Column(nullable=false)
	private boolean canteen;
	
	@Column(nullable=false)
	private boolean clinic;
	
	@Column(nullable=false)
	private boolean wifi;
	
	@Column(nullable=false)
	private boolean cabelInternet;
	
	@Column(nullable=false)
	private boolean standByGenerator;	
	
	@Column(nullable=false, updatable=false)
	@CreatedDate
	@CreationTimestamp
	private Timestamp dateCreated;
	
	@Column(nullable=false)
	@LastModifiedDate
	@UpdateTimestamp
	private Timestamp lastUpdated;		

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="facility_id", referencedColumnName="facilityId", nullable=false)
	private Facility facility;
	
	

}
