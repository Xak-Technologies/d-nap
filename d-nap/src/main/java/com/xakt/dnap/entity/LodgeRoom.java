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
public class LodgeRoom {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long roomId;
	
	@Column(nullable=false, length=15)
	private String roomNumber;
	
	@Column(nullable=false, length=15)
	private String floor;
	
	@Column(nullable=false)
	private Long roomPrice;
	
	@Column(nullable=false, length=15)
	private String paymentPartern;
	
	@Column(nullable=false)
	private Integer beds;
	
	@Column(nullable=false)
	private boolean washRoom;
	
	@CreationTimestamp
	@CreatedDate
	@Column(nullable=false, updatable=false)
	private Timestamp dateAdded;
	
	@UpdateTimestamp
	@LastModifiedDate
	@Column(nullable=false)
	private Timestamp lastUpdated;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="lodge_id", referencedColumnName="lodgeId")
	private Lodge lodge;

}
