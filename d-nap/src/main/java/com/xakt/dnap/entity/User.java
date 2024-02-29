package com.xakt.dnap.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@EntityListeners(AuditingEntityListener.class)
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	
	@NotBlank(message="Please add first name")
	@Length(max=45, min=3)
	@Column(name="first_name")
	private String firstName;
	
	
	@NotBlank(message="Please add last name")
	@Length(max=45, min=3)
	@Column(name="last_name")
	private String lastName;
	
	
	@Column(name="other_names")
	@Length(max=100, min=3)
	private String otherNames;
	
	
	@Email
	@NotBlank(message="Please add email")
	@Length(max=50, min=10)
	@Column(name="user_email", unique=true)
	private String userEmail;
	
	
	@NotBlank(message="Please add telephone")
	@Length(max=15, min=6)
	@Column(name="user_telephone", unique=true)
	private String userTelephone;	
	
	
	@NotBlank(message="Please add a password")
	@Length(max=25, min=6)
	@Column(name="user_password")
	private String userPassword;
	
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_created", nullable=false, updatable=false)
	@Length(max=25)
	private String createdDate;
	
	
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated", nullable=false)
	@Length(max=25)
	private String lastUpdated;	

}
