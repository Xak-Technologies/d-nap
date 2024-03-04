package com.xakt.dnap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

}
