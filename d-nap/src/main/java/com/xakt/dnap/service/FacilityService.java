package com.xakt.dnap.service;

import java.util.List;
import com.xakt.dnap.entity.Facility;
import com.xakt.dnap.error.AlreadyExistsException;
import com.xakt.dnap.error.BlankFieldException;
import com.xakt.dnap.error.NotFoundException;
import com.xakt.dnap.error.SuccessMessageException;

import jakarta.validation.Valid;

public interface FacilityService {

	public void saveFacility(@Valid Facility facility) 
			throws BlankFieldException, SuccessMessageException, NotFoundException, AlreadyExistsException;
	

	public List<Facility> fetchFacilities() throws NotFoundException;
	

	public void deleteFacility(Long facilityId) throws NotFoundException, SuccessMessageException;
	

	public void editFacility(Long facilityId, Facility facility) 
			throws NotFoundException, SuccessMessageException, AlreadyExistsException;

}
