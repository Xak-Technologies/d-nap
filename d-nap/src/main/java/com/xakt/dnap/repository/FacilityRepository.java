package com.xakt.dnap.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xakt.dnap.entity.Facility;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {

	@Query(value="SELECT COUNT(facility_id) FROM facility WHERE facility_name = :facilityName AND "
			+ "landlord_id = :landlordId AND country = :country AND city = :city AND "
			+ "zone = :zone AND street = :street", nativeQuery=true)
	Integer findDuplicateFacility(String facilityName, Long landlordId, String country, String city,
			String zone, String street);
	
	
	@Query(value="SELECT COUNT(facility_id) FROM facility WHERE facility_name = :facilityName AND "
			+ "landlord_id != :landlordId AND country = :country AND city = :city AND "
			+ "zone = :zone AND street = :street", nativeQuery=true)
	Integer findDuplicateFacilityUpdate(String facilityName, Long landlordId, String country, String city, String zone,
			String street);


	Optional<Facility> findByFacilityId(Long facilityId);

	@Query(value="SELECT COUNT(facility_id) FROM facility WHERE facility_id != :facilityId AND "
			+ "facility_name = :facilityName AND "
			+ "(landlord_id = :landlordId OR landlord_id != :landlordId ) AND "
			+ "country = :country AND city = :city AND "
			+ "zone = :zone AND street = :street", nativeQuery=true)
	Integer findDuplicateFacilityEdit(Long facilityId, String facilityName, Long landlordId, String country, String city, String zone,
			String street);

}
