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
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HostelRoom {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long roomId;
	
	@Length(max=25, min=3)
	@Column(name="room_category", nullable=false)
	@NotBlank(message="Please add room category")
	private String roomCategory;
	
	@Length(max=15, min=3)
	@Column(name="floor", nullable=false)
	@NotBlank(message="Please add floor")
	private String floor;
	
	@Length(max=5, min=1)
	@Column(name="room_number", nullable=false)
	@NotBlank(message="Please add room room number")
	private String roomNumber;
	
	@Length(max=5, min=1)
	@Column(name="room_length", nullable=false)
	@NotBlank(message="Please add room length")
	private String roomLength;
	
	@Length(max=5, min=1)
	@Column(name="room_width", nullable=false)
	@NotBlank(message="Please add room width")
	private String roomWidth;
	
	@Column(name="kitchen", nullable=false)
	private Boolean kitchen;	
	
	@Column(name="shower_room", nullable=false)
	private Boolean showerRoom;
	
	
	@Column(name="toilet", nullable=false)
	private Boolean toilet;
	
	@Column(name="room_price", nullable=false)
	private String roomPrice;	
	
	
	@Column(name="fully_fanished", nullable=false)
	private Boolean fullyFunished;
	
	@CreatedDate
	@CreationTimestamp
	@Column(name="date_created", nullable=false, updatable=false)
	private Timestamp dateCreated;
	
	@LastModifiedDate
	@UpdateTimestamp
	@Column(name="last_updated", nullable=false)
	private Timestamp lastUpdated;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="room_id", referencedColumnName="roomId", nullable=true)
	private List<Tenant> tenants;	
	

}
