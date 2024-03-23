package com.xakt.dnap.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

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
public class TenantPayment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long paymentId;
	
	@Column(nullable=false)
	private Integer period;
	
	@Column(nullable=false)
	private Long amount;
	
	@Column(nullable=false, length=25)
	private String paymentMethod;
	
	@Column(nullable=false, updatable=false)
	@CreatedDate
	@CreationTimestamp
	private Timestamp dateAdded;	
	
	@Column(nullable=false, updatable=false)
	private Timestamp datePaid;	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tenant_id", referencedColumnName="tenantId")
	private Tenant tenant;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PRoom_id", referencedColumnName="roomId")
	private HotelRoom hotelRoom;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PRoom_id", referencedColumnName="roomId", insertable=false, updatable=false)
	private HostelRoom hostelRoom;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PRoom_id", referencedColumnName="apartmentId", insertable=false, updatable=false)
	private Apartment apartment;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PRoom_id", referencedColumnName="roomId", insertable=false, updatable=false)
	private ShopRoom shopRoom;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PRoom_id", referencedColumnName="homeId", insertable=false, updatable=false)
	private Home home;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PRoom_id", referencedColumnName="roomId", insertable=false, updatable=false)
	private OfficeRoom officeRoom;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PRoom_id", referencedColumnName="roomId", insertable=false, updatable=false)
	private RentalRoom rentalRoom;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PRoom_id", referencedColumnName="conferenceSpaceId", insertable=false, updatable=false)
	private ConferenceSpace conferenceSpace;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PRoom_id", referencedColumnName="spaceId", insertable=false, updatable=false)
	private EventsSpace eventsSpace;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PRoom_id", referencedColumnName="roomId", insertable=false, updatable=false)
	private LodgeRoom lodgeRoom;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PRoom_id", referencedColumnName="spaceId", insertable=false, updatable=false)
	private MeetingSpace meetingSpace;

}
