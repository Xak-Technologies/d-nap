package com.xakt.dnap.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xakt.dnap.entity.Facility;
import com.xakt.dnap.repository.FacilityRepository;

import jakarta.validation.Valid;


@Service
public class FacilityServiceImplementation implements FacilityService {

	@Autowired
	FacilityRepository facilityRepository;
	
	@Override
	public Facility saveFacility(@Valid Facility facility) {
		return facilityRepository.save(facility);
	}

	@Override
	public List<Facility> fetchFacilities() {
		return facilityRepository.findAll();
	}

	@Override
	public void deleteFacility(Long facilityId) {
		facilityRepository.deleteById(facilityId);
		
	}

	@Override
	public Facility editFacility(Long facilityId, Facility facility) {
		Facility facilityDB = facilityRepository.findById(facilityId).get();
		if(Objects.nonNull(facility.getFacilityCategory()) &&
				!"".equalsIgnoreCase(facility.getFacilityCategory())) {
			facilityDB.setFacilityCategory(facility.getFacilityCategory());
		}
		
		if(Objects.nonNull(facility.getFacilityName()) &&
				!"".equalsIgnoreCase(facility.getFacilityName())) {
			facilityDB.setFacilityName(facility.getFacilityName());
		}
		return facilityRepository.save(facilityDB);
	}

}
