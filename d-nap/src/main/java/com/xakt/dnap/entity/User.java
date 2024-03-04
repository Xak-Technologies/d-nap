package com.xakt.dnap.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
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
//@Table(name="user")
public class User {
	
	
	@Id
//	@SequenceGenerator(
//			name="user_sequence", 
//			sequenceName="user_sequence", 
//			allocationSize=1
//			)
//	@GeneratedValue(
//			strategy = GenerationType.SEQUENCE, 
//			generator="user_sequence"
//			)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	
	@NotBlank(message="Please add first name")
	@Length(max=45, min=3)
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	
	@NotBlank(message="Please add last name")
	@Length(max=45, min=3)
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	
	@Column(name="other_names")
	@Length(max=100, min=3)
	private String otherNames;
	
	
	@Email
	@NotBlank(message="Please add email")
	@Length(max=50, min=10)
	@Column(name="user_email", unique=true, nullable=false)
	private String userEmail;
	
	
	@NotBlank(message="Please add telephone")
	@Length(max=15, min=6)
	@Column(name="user_telephone", unique=true, nullable=false)
	private String userTelephone;	
	
	
	@NotBlank(message="Please add a password")
	@Length(max=25, min=6)
	@Column(name="user_password", nullable=false)
	private String userPassword;
	
	@NotBlank(message="Please add user category.")
	@Length(max=50, min=3)
	@Column(name="user_category", nullable=false)
	private String userCategory;
	
	
	@CreatedDate
	@CreationTimestamp
	@Column(name="date_created", updatable=false)
	private Timestamp createdDate;
	
	
	@LastModifiedDate
	@UpdateTimestamp
	@Column(name="last_updated")
	private Timestamp lastUpdated;	

}
