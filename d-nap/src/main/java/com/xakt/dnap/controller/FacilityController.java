package com.xakt.dnap.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xakt.dnap.entity.Facility;
import com.xakt.dnap.service.FacilityService;

import jakarta.validation.Valid;

@RestController
public class FacilityController {
	
	@Autowired
	FacilityService facilityService;
	
	
	@PostMapping("/api/saveFacility")
	public Facility saveFacility(@Valid @RequestBody Facility facility) {
		return facilityService.saveFacility(facility);		
	}
	
	
	@GetMapping("/api/fetchFacilities")
	public List<Facility> fetchFacilities(){
		return facilityService.fetchFacilities();		
	}
	
	@DeleteMapping("/api/deleteFacility/{facility_id}")
	public String deleteFacility(@PathVariable("facility_id") Long facilityId){
		facilityService.deleteFacility(facilityId);
		return "Facility deleted successfully";		
	}
	
	
	@PutMapping("/api/editFacility/{facility_id}")
	public Facility editFacility(@PathVariable("facility_id") Long facilityId, @RequestBody Facility facility){
		return facilityService.editFacility(facilityId, facility);
	}

}
