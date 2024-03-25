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
public class User {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	@NotBlank(message="Please add user category.")
	@Length(max=20, min=3)
	@Column(name="user_role", nullable=false)
	private String userRole;
	
	@Email
	@NotBlank(message="Please add email")
	@Length(max=50, min=10)
	@Column(name="user_email", unique=true, nullable=false)
	private String userEmail;	
	
	@NotBlank(message="Please add a password")
	@Length(max=25, min=6)
	@Column(name="user_password", nullable=false)
	private String userPassword;	
	
	@CreatedDate
	@CreationTimestamp
	@Column(name="date_created", updatable=false)
	private Timestamp createdDate;
	
	
	@LastModifiedDate
	@UpdateTimestamp
	@Column(name="last_updated")
	private Timestamp lastUpdated;	
	
}
