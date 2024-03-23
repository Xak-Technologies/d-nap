package com.xakt.dnap.service;

import java.util.List;

import com.xakt.dnap.entity.Landlord;
import com.xakt.dnap.error.AlreadyExistsException;
import com.xakt.dnap.error.BlankFieldException;
import com.xakt.dnap.error.NotFoundException;
import com.xakt.dnap.error.SuccessMessageException;

public interface LandlordService {

	void saveLandlord(Landlord landlord) 
			throws NotFoundException, AlreadyExistsException, 
			SuccessMessageException, BlankFieldException;

	List<Landlord> fetchLandlords() throws NotFoundException;

	Landlord fetchLandlordById(Long landlordId) throws NotFoundException;

	void deleteLandlordById(Long landlordId) throws NotFoundException, SuccessMessageException;
	
	void deleteLandlordByUserId(Long id);

}
