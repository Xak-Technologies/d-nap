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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelRoom {	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long roomId;
	
	@Column(nullable=false)
	@Length(max=10)
	private String roomNumber;
	
	@Column(nullable=false)
	@Length(max=15)
	private String floor;
	
	@Column(nullable=false)
	@Length(max=30)
	private String roomCategory;	
	
	@Column(nullable=false)
	@Length(max=25)
	private String roomPrice;
	
	@Column(nullable=false)
	@Length(max=15)
	private String PaymentPartten;
	
	@Column(nullable=false, updatable=false)
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
	@JoinColumn(name="hotel_id", referencedColumnName="motelId", nullable=false, insertable=false, updatable=false)
	private Motel motel;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tenant_id", referencedColumnName="tenantId")
	private Tenant tenant;
	
	
}
