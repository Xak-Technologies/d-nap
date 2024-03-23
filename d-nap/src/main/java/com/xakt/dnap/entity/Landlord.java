package com.xakt.dnap.entity;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Landlord {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long landlordId;
	
	@Column(nullable=false, length=30)
	private String firstName;
	
	@Column(nullable=false, length=30)
	private String lastName;
	
	@Column(nullable=true, length=50)
	private String otherNames;
	
	@Column(nullable=false, length=25, unique=true)
	private String nationalId;
	
	@Embedded
	private Contact contact;
	
	@Embedded
	private Address address;
	
	@CreationTimestamp
	@CreatedDate
	@Column(updatable=false)
	private Timestamp dateCreated;
	
	@UpdateTimestamp
	@LastModifiedDate
	private Timestamp lastUpdated;
	
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="user_id", referencedColumnName="userId", nullable=false)
	private User user;	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="landlord_id", referencedColumnName="landLordId", nullable=false)
	private List<Facility> facilities;

}
