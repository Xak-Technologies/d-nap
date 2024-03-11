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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roomId;
	
	@Column(name="room_number", nullable=false)
	private String roomNumber;
	
	@Column(name="room_location", nullable=false)
	private String roomLocation;
	
	@Column(name="floor", nullable=false)
	private String floor;
	
	@Column(name="room_length", nullable=false)
	private String roomLength;
	
	@Column(name="room_width", nullable=false)
	private String roomWidth;
	
	@Column(name="room_price", nullable=false)
	private String roomPrice;
	
	@Column(name="rent_parttern", nullable=false)
	private String rentParttern;
	
	@CreatedDate
	@CreationTimestamp
	@Column(name="date_created", nullable=false, updatable=false)
	private Timestamp dateCreated;
	
	@LastModifiedDate
	@UpdateTimestamp
	@Column(name="last_updated", nullable=false)
	private Timestamp lastUpdated;

}
