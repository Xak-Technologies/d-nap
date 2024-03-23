package com.xakt.dnap.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xakt.dnap.entity.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{

	List<User> findByUserEmail(String userEmail);

	void deleteByUserId(Long id);

	Optional<User> findByUserId(Long id);
	
}
  