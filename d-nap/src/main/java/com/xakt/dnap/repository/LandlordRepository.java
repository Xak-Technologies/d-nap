package com.xakt.dnap.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xakt.dnap.entity.Landlord;

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

	@Query(value="SELECT * FROM landlord WHERE landlord_id != :landlordId AND email = :email", nativeQuery=true )
	Optional<Landlord> findOthersWithSameEmail(Long landlordId, String email);

	@Query(value="SELECT * FROM landlord WHERE landlord_id != :landlordId AND telephone1 = :telephone1", nativeQuery=true)
	Optional<Landlord> findOthersWithSameTelephone1(Long landlordId, String telephone1);

	@Query(value="SELECT * FROM landlord WHERE landlord_id != :landlordId AND telephone2 = :telephone2", nativeQuery=true)
	Optional<Landlord> findOthersWithSameTelephone2(Long landlordId, String telephone2);
	
	@Query(value="SELECT * FROM landlord WHERE landlord_id != :landlordId AND national_id = :nationalId", nativeQuery=true)
	Optional<Landlord> findOthersWithSameNationalId(Long landlordId, String nationalId);	

	
}
