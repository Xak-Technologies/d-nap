package com.xakt.dnap.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xakt.dnap.entity.Facility;
import com.xakt.dnap.error.BlankFieldException;
import com.xakt.dnap.error.NotFoundException;
import com.xakt.dnap.error.SuccessMessageException;
import com.xakt.dnap.repository.FacilityRepository;

import jakarta.validation.Valid;


@Service
public class FacilityServiceImplementation implements FacilityService {

	@Autowired
	FacilityRepository facilityRepository;
	
	
/*
 * ADDING A NEW FACILITY
 * This method;
 * 1. Checks for blank required field, throws a BlankFieldException and 
 * 		return a blank field exception to the client side for 
 * 		each blank required field. 
 * 2. If all conditions are fulfilled, it saves the facility to the database 
 * 		and return success message to the client side.
 */	
	@Override
	public void saveFacility(@Valid Facility facility) 
			throws BlankFieldException, SuccessMessageException {
		if(Objects.isNull(facility.getFacilityName()) || "".equalsIgnoreCase(facility.getFacilityName())) {
			throw new BlankFieldException("Please add facility name");
		}
		
		if(Objects.isNull(facility.getFacilityCategory()) || "".equalsIgnoreCase(facility.getFacilityCategory())) {
			throw new BlankFieldException("Please add facility category");
		}		
		
		facilityRepository.save(facility);
		throw new SuccessMessageException("Facility has been saved successfully.");
		
	}
	
	

/*
 * FETCHING A LIST OF FACILITIES
 * This method fetches a of facilities.
 * If no facility found in the database, it throws a NotFoundException
 * 	and return a No facility found message to the client side.
 * If a one or more facilities are found in the database, it returns 
 * 	a list of facilities to the client side.
 */
	@Override
	public List<Facility> fetchFacilities() throws NotFoundException {
		List<Facility> facilitiesDB = facilityRepository.findAll();
		if(facilitiesDB.isEmpty()) {
			throw new NotFoundException("No facility found");
		}		
		return facilitiesDB;
	}
	
	

/*
 * DELETING A FACILITY
 * This method delete a facility from the database depending on the passed facility ID.
 * If the facility doesn't exist in the database, it throws a NotFoundException and 
 * 	returns a Facility not found message to the client side. 
 */
	@Override
	public void deleteFacility(Long facilityId) 
			throws NotFoundException, SuccessMessageException {
		Optional<Facility> facilityDB = facilityRepository.findById(facilityId);
		
		if(!facilityDB.isPresent()) {
			throw new NotFoundException("Facility not found.");
		}
		
		facilityRepository.deleteById(facilityId);
		throw new SuccessMessageException("Facility has been deleted successFully.");		
	}	
	
	

/*
 * UPDATING A FACILITY INFORMATION
 * This method first checks if the facility exists in the database.
 * If the facility doesn't exist, it throws a NotFoundException and
 * 	return a Facility not found message to the client side.
 * If the facility exists in the database, it updates the database, its info is updated and
 *  the method return a Facility updated successfully message to the client side.
 */
	@Override
	public void editFacility(Long facilityId, Facility facility) 
			throws NotFoundException, SuccessMessageException {
		
		Optional<Facility> facilityDBFound = facilityRepository.findById(facilityId);
		if(facilityDBFound.isEmpty()) {
			throw new NotFoundException("Facility not found");
		}		
		
		Facility facilityDB = facilityRepository.findById(facilityId).get();
		
		if(Objects.nonNull(facility.getFacilityCategory()) &&
				!"".equalsIgnoreCase(facility.getFacilityCategory())) {
			facilityDB.setFacilityCategory(facility.getFacilityCategory());
		}
		
		if(Objects.nonNull(facility.getFacilityName()) &&
				!"".equalsIgnoreCase(facility.getFacilityName())) {
			facilityDB.setFacilityName(facility.getFacilityName());
		}
		
		facilityRepository.save(facilityDB);
		throw new SuccessMessageException("Facility updated successfully.");
	}

}
