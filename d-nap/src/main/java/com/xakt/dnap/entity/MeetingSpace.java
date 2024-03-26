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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeetingSpace {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long spaceId;
	
	@Column(nullable=false)
	private int capacity;
	
	@Column(nullable=false)
	private Long price;
	
	@Column(nullable=false)
	private Boolean available;
	
	@Column(nullable=false)
	@CreatedDate
	@CreationTimestamp
	private Timestamp dateCreated;
	
	@Column(nullable=false)
	@LastModifiedDate
	@UpdateTimestamp
	private Timestamp lastUpdated;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="hotel_id", referencedColumnName="hotelId", nullable=false)
	private Hotel hotel;	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="hotel_id", referencedColumnName="MotelId", nullable=false, insertable=false, updatable=false)
	private Motel Motel; 

}
