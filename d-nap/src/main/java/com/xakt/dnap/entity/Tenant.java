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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class Tenant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long tenantId;
	
	@Column(nullable=false, length=30)
	private String firstName;
	
	@Column(nullable=false, length=30)
	private String lastName;
	
	@Column(nullable=true, length=50)
	private String otherNames;
	
	@Column(nullable=false, length=25)
	private String nationalId;
	
	@Embedded
	private Contact contact;
	
	@CreationTimestamp
	@CreatedDate
	@Column(updatable=false)
	private Timestamp dateCreated;
	
	@UpdateTimestamp
	@LastModifiedDate
	private Timestamp lastUpdated;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id", referencedColumnName="userId")
	private User user;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tenant_facilities",
        joinColumns = @JoinColumn(name = "tenant_id"),
        inverseJoinColumns = @JoinColumn(name = "facility_id"))
    private List<Facility> facilities; 	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="room_id", referencedColumnName="roomId")
	private HotelRoom hotelRoom;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="room_id", referencedColumnName="roomId", insertable=false, updatable=false)
	private HostelRoom hostelRoom;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="room_id", referencedColumnName="roomId", insertable=false, updatable=false)
	private MotelRoom motelRoom;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="room_id", referencedColumnName="roomId", insertable=false, updatable=false)
	private ShopRoom shopRoom;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="room_id", referencedColumnName="apartmentId", insertable=false, updatable=false)
	private Apartment apartment;	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="room_id", referencedColumnName="homeId", insertable=false, updatable=false)
	private Home home;

}
