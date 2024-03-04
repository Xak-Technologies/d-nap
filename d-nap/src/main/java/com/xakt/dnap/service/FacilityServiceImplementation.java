package com.xakt.dnap.service;

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

}
