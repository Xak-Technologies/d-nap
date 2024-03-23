package com.xakt.dnap.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xakt.dnap.entity.Landlord;
import com.xakt.dnap.entity.User;
import com.xakt.dnap.error.AlreadyExistsException;
import com.xakt.dnap.error.BlankFieldException;
import com.xakt.dnap.error.NotFoundException;
import com.xakt.dnap.error.SuccessMessageException;
import com.xakt.dnap.repository.LandlordRepository;
import com.xakt.dnap.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class LandlordServiceImplementation implements LandlordService{
	
	@Autowired
	LandlordRepository landlordRepository;
	
	@Autowired
	UserRepository userRepository;

	
/*
 * ADDING A NEW LANDLORD TO THE DATABASE
 */
	@Override
	public void saveLandlord(Landlord landlord) 
			throws NotFoundException, AlreadyExistsException, 
			SuccessMessageException, BlankFieldException {		
		
/*
 * CHECKING IF THE REFERENCED USER ID EXISTS
 */		
		Optional<User> user = userRepository.findById(landlord.getUser().getUserId());

		if(user.isEmpty()) {
			throw new NotFoundException("User account does not exist.");
		}
		
		
/*
 * CHECKING IF THE REFERENCED USER ID ALREADY USED BY ANOTHER LANDLORD
 */
		Optional<Landlord> landlordDB = 
				landlordRepository.findByUserUserId(landlord.getUser().getUserId());
		if(landlordDB.isPresent()) {
			throw new AlreadyExistsException("Landlord with similar details already exists.");
		}
		
		
/*
 * CHECKING FOR DUPLICATE UNIQUE FIELDS IN THE LANDLORD TABLE
 * email, telephone1, telephone2, national ID
 */		
		Optional<Landlord> landlordDBEmail = 
				landlordRepository.findByContactEmail(landlord.getContact().getEmail());
		if(landlordDBEmail.isPresent()) {
			throw new AlreadyExistsException("Email already used .");
		}
		
		Optional<Landlord> landlordDBTelephone1 = 
				landlordRepository.findByContactTelephone1(landlord.getContact().getTelephone1());
		if(landlordDBTelephone1.isPresent()) {
			throw new AlreadyExistsException("Telephone1 already used .");
		}
		
		Optional<Landlord> landlordDBTelephone2 = 
				landlordRepository.findByContactTelephone2(landlord.getContact().getTelephone2());
		if(landlordDBTelephone2.isPresent()) {
			throw new AlreadyExistsException("Telephone2 already used .");
		}
		
		Optional<Landlord> landlordDBTelephone12 = 
				landlordRepository.findByContactTelephone1(landlord.getContact().getTelephone2());
		if(landlordDBTelephone12.isPresent()) {
			throw new AlreadyExistsException("Telephone2 already used .");
		}
		
		Optional<Landlord> landlordDBTelephone21 = 
				landlordRepository.findByContactTelephone2(landlord.getContact().getTelephone1());
		if(landlordDBTelephone21.isPresent()) {
			throw new AlreadyExistsException("Telephone1 already used .");
		}
		
		Optional<Landlord> landlordDBNationalId = 
				landlordRepository.findByNationalId(landlord.getNationalId());
		if(landlordDBNationalId.isPresent()) {
			throw new AlreadyExistsException("National Id already used.");
		}
		
		
/*
 * CHECKING FOR NULL OR EMPTY REQUIRED FIELDS
 */		
		if(Objects.isNull(landlord.getFirstName()) || 
				"".equalsIgnoreCase(landlord.getFirstName())) {
			 throw new BlankFieldException("Please add first name.");
		}
		
		if(Objects.isNull(landlord.getLastName()) || 
				"".equalsIgnoreCase(landlord.getLastName())) {
			 throw new BlankFieldException("Please add last name.");
		}
		
		if(Objects.isNull(landlord.getNationalId()) || 
				"".equalsIgnoreCase(landlord.getNationalId())) {
			 throw new BlankFieldException("Please add national ID.");
		}
		
		if(Objects.isNull(landlord.getContact().getTelephone1()) || 
				"".equalsIgnoreCase(landlord.getContact().getTelephone1())) {
			 throw new BlankFieldException("Please add primary phone contant");
		}
		
		if(Objects.isNull(landlord.getLastName()) || 
				"".equalsIgnoreCase(landlord.getLastName())) {
			 throw new BlankFieldException("Please add last name.");
		}
		
		if(Objects.isNull(landlord.getContact().getEmail()) || 
				"".equalsIgnoreCase(landlord.getContact().getEmail())) {
			 throw new BlankFieldException("Please add email.");
		}
		
		if(Objects.isNull(landlord.getAddress().getCountry()) || 
				"".equalsIgnoreCase(landlord.getAddress().getCountry())) {
			 throw new BlankFieldException("Please add country.");
		}
		
		if(Objects.isNull(landlord.getAddress().getCity()) || 
				"".equalsIgnoreCase(landlord.getAddress().getCity())) {
			 throw new BlankFieldException("Please add city or district.");
		}
		
		if(Objects.isNull(landlord.getAddress().getZone()) || 
				"".equalsIgnoreCase(landlord.getAddress().getZone())) {
			 throw new BlankFieldException("Please add village or zone.");
		}		
		
		
		landlord.setUser(user.get()); // SETING THE REFERENCED USER ID TO THE LANDLORD		
		landlordRepository.save(landlord); // SAVING THE LANDLORD DETAILS TO THE DATABASE
		throw new SuccessMessageException("Landlord details saved successfully."); // RETURN A SUCCESS MESSAGE
		
	}
	
	
/*
 * FETCHING A LIST OF ALL LANDLORDS
 */

	@Override
	public List<Landlord> fetchLandlords() throws NotFoundException {
		List<Landlord> landlords = landlordRepository.findAll();
		if(landlords.isEmpty()) {
			throw new NotFoundException("No landlord was found");
		}
		
		return landlords;
	}

	
/*
 * FETCHING LANDLORD BY ID
 */
	@Override
	public Landlord fetchLandlordById(Long landlordId) throws NotFoundException {
		Optional<Landlord> landlordDB = landlordRepository.findByLandlordId(landlordId);
		
		if(landlordDB.isEmpty()) {
			throw new NotFoundException("Landlord not found.");
		}
		
		return landlordDB.get();
	}


/*
 * DELETING LANDLORD BY ID
 */
	@Override
	@Transactional
	public void deleteLandlordById(Long landlordId) throws NotFoundException, SuccessMessageException {
		Optional<Landlord> landlordDB = landlordRepository.findByLandlordId(landlordId);
		if(landlordDB.isEmpty()) {
			throw new NotFoundException("Landlord not found.");
		}
		
		landlordRepository.deleteByLandlordId(landlordId);
		throw new SuccessMessageException("Landlord has been deleted successfully.");
		
	}


	@Override
	@Transactional
	public void deleteLandlordByUserId(Long id) {
		landlordRepository.deleteByUserUserId(id);
		
	}

}
