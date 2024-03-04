package com.xakt.dnap.service;

import com.xakt.dnap.entity.Facility;

import jakarta.validation.Valid;

public interface FacilityService {

	Facility saveFacility(@Valid Facility facility);

}
