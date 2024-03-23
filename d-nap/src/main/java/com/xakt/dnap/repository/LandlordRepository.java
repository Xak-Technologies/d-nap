package com.xakt.dnap.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xakt.dnap.entity.Landlord;

import jakarta.transaction.Transactional;

@Repository
public interface LandlordRepository extends JpaRepository<Landlord, Long> {

	Optional<Landlord> findByUserUserId(Long userId);

	Optional<Landlord> findByContactEmail(String email);

	Optional<Landlord> findByContactTelephone1(String telephone1);

	Optional<Landlord> findByContactTelephone2(String telephone2);

	Optional<Landlord> findByNationalId(String nationalId);

	Optional<Landlord> findByLandlordId(Long landlordId);

	void deleteByLandlordId(Long landlordId);

	void deleteByUserUserId(Long id);
}
