package com.xakt.dnap.entity;

import java.sql.Timestamp;
import java.util.List;

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
import jakarta.persistence.OneToMany;
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
public class Lodge {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long lodgeId;
	
	@Column(nullable=false)
	private boolean parking;
	
	@Column(nullable=false)
	private boolean wifi;
	
	@Column(nullable=false)
	private boolean standbyGenerator;
	
	@Column(nullable=false)
	private boolean breakFast;
	
	@Column(nullable=false)
	private boolean surveilenceCameras;
	
	@Column(nullable=false)
	private boolean securityGuard;
	
	@Column(nullable=false)
	private boolean bar;
	
	@Column(nullable=false)
	private boolean restaurant;
	
	@CreationTimestamp
	@CreatedDate
	@Column(nullable=false, updatable=false)
	private Timestamp dateAdded;
	
	@UpdateTimestamp
	@LastModifiedDate
	@Column(nullable=false)
	private Timestamp lastUpdated;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="facility_id", referencedColumnName="facilityId")
	private Facility facility;
	
	
	

}
