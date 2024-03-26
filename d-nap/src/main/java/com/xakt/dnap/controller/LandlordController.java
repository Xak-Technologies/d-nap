package com.xakt.dnap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xakt.dnap.entity.Landlord;
import com.xakt.dnap.error.AlreadyExistsException;
import com.xakt.dnap.error.BlankFieldException;
import com.xakt.dnap.error.NotFoundException;
import com.xakt.dnap.error.SuccessMessageException;
import com.xakt.dnap.service.LandlordService;

@RestController
public class LandlordController {
	
	@Autowired	
	LandlordService landlordService;
	
	
/*
 * ADDING AN NEW LANDLORD TO THE DATABASE
 */
	@PostMapping("/api/saveLandlord")
	public void saveLandlord( @RequestBody Landlord landlord) 
			throws NotFoundException, AlreadyExistsException, 
			SuccessMessageException, BlankFieldException {
		landlordService.saveLandlord(landlord);
	}
	
	
/*
 * FETCHING A LIST OF LANDLORDS
 */
	@GetMapping("/api/fetchLandlords")
	public List<Landlord> fetchLandlords() throws NotFoundException{
		return landlordService.fetchLandlords();
	}
	
	
/*
 * FETCHING A LANDLORD BY ID	
 */
	@GetMapping("/api/fetchLandlordById/{landlord_id}")
	public Landlord fetchLandlordById(@PathVariable("landlord_id") Long landlordId) throws NotFoundException {
		
		return landlordService.fetchLandlordById(landlordId);
	}	
	
	
/*
 * DELETING A LANDLORD BY ID
 */
	@DeleteMapping("/api/deleteLandlordById/{landlord_id}")
	public void deleteLandlordById(@PathVariable("landlord_id") Long landlordId) 
			throws NotFoundException, SuccessMessageException {
		landlordService.deleteLandlordById(landlordId);
	}
	
	
/*
 * UPDATING LANDLORD'S INFO
 */
	@PutMapping("/api/updateLandlord/{landlord_id}")
	public void updateLandlord(@PathVariable("landlord_id") Long landlordId, @RequestBody Landlord landlord) 
			throws NotFoundException, SuccessMessageException, AlreadyExistsException {
		landlordService.updateLandlord(landlordId, landlord);
	}
}
