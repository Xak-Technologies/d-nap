package com.xakt.dnap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xakt.dnap.entity.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{

	
}
