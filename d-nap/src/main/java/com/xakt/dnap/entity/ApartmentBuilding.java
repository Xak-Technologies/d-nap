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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApartmentBuilding {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long apartmentBuildingId;
	
	@Column(nullable=false)
	private boolean gym;
	
	@Column(nullable=false)
	private boolean swimingPool;
	
	@Column(nullable=false)
	private boolean parking;
	
	@Column(nullable=false)
	private boolean wifi;
	
	@Column(nullable=false)
	private boolean cabelInternet;
	
	@Column(nullable=false)
	private boolean standByGenerator;
	
	@Column(nullable=false)
	private boolean elevator;
	
	@Column(nullable=false)
	private boolean surveillanceCameras;
	
	@Column(nullable=false)
	private boolean communityRoom;
	
	@Column(nullable=false)
	private boolean securityGuard;	
	
	@Column(nullable=false, updatable=false)
	@CreatedDate
	@CreationTimestamp
	private Timestamp dateCreated;
	
	@Column(nullable=false)
	@LastModifiedDate
	@UpdateTimestamp
	private Timestamp lastUpdated;

}
