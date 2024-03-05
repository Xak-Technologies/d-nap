package com.xakt.dnap.service;

import java.util.List;
import java.util.Optional;

import com.xakt.dnap.entity.Facility;

import jakarta.validation.Valid;

public interface FacilityService {

	public Facility saveFacility(@Valid Facility facility);

	public List<Facility> fetchFacilities();

	public void deleteFacility(Long facilityId);

	public Facility editFacility(Long facilityId, Facility facility);

}
