package com.xakt.dnap.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xakt.dnap.entity.Facility;
import com.xakt.dnap.error.AlreadyExistsException;
import com.xakt.dnap.error.BlankFieldException;
import com.xakt.dnap.error.NotFoundException;
import com.xakt.dnap.error.SuccessMessageException;
import com.xakt.dnap.service.FacilityService;

@RestController
public class FacilityController {
	
	@Autowired
	FacilityService facilityService;
	
	
	private final Logger LOGGER = LoggerFactory.getLogger(FacilityController.class);
	
	
//	ADDING A NEW FACILITY
	@PostMapping("/api/saveFacility")
	public void saveFacility(@RequestBody Facility facility) 
			throws BlankFieldException, SuccessMessageException, NotFoundException, AlreadyExistsException {
		LOGGER.info("Inside save facility of FacilityControler.");
		facilityService.saveFacility(facility);		
	}
	

//	FETCHING A LIST OF FACILITIES
	@GetMapping("/api/fetchFacilities")
	public List<Facility> fetchFacilities() throws NotFoundException {
		LOGGER.info("Inside fetchFacilities of FacilityController.");
		return facilityService.fetchFacilities();		
	}	
	

//	DELETEING A FACILITY DEPENDING ON ID
	@DeleteMapping("/api/deleteFacility/{facility_id}")
	public void deleteFacility(@PathVariable("facility_id") Long facilityId) 
			throws NotFoundException, SuccessMessageException{
		LOGGER.info("Inside deleteFacility of FacilityController.");
		facilityService.deleteFacility(facilityId);
	}
	

//	UPDATING FACILITY DEPENDING ON ID
	@PutMapping("/api/editFacility/{facility_id}")
	public void editFacility(@PathVariable("facility_id") Long facilityId,
			@RequestBody Facility facility) 
					throws NotFoundException, SuccessMessageException, AlreadyExistsException {
		LOGGER.info("Inside editFacility of FacilityController.");
		facilityService.editFacility(facilityId, facility);
	}
	
}
