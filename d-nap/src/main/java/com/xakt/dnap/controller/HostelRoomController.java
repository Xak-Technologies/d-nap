package com.xakt.dnap.controller;

import java.util.List;
import java.util.Optional;

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

import com.xakt.dnap.entity.HostelRoom;
import com.xakt.dnap.error.BlankFieldException;
import com.xakt.dnap.error.NotFoundException;
import com.xakt.dnap.error.SuccessMessageException;
import com.xakt.dnap.service.HostelRoomService;


@RestController
public class HostelRoomController {
	
	@Autowired
	HostelRoomService hostelRoomService;
	
	Logger LOGGER = LoggerFactory.getLogger(HostelRoomController.class);
	
	
//	ADDING A NEW HOSTEL ROOM TO THE DATABASE
	@PostMapping("/api/addNewHostelRoom")
	public void addNewHostelRoom(@RequestBody HostelRoom hostelRoom) 
			throws BlankFieldException, SuccessMessageException {
		LOGGER.info("Inside addNewHostelRoom of HostelRoomController.");
		hostelRoomService.addNewHostelRoom(hostelRoom);
	}
	
	
//	FETCHING THE LIST OF HOSTELS
	@GetMapping("/api/fetchHostelRooms")
	public List<HostelRoom> fetchHostelRooms() throws NotFoundException{
		LOGGER.info("Inside fetchHostelRooms of HostelRoomController.");
		return hostelRoomService.fetchHostelRooms();
	}
	
	
//	FETCHING HOSTEL ROOM DEPENDING ON THE ID
	@GetMapping("/api/fetchHostelRoomById/{room_id}")
	public Optional<HostelRoom> fetchHostelRoomById(@PathVariable("room_id") Long roomId) 
			throws NotFoundException{
		LOGGER.info("Inside fetchHostelRoomById of HostelRoomController.");
		return hostelRoomService.findHostelRoomById(roomId);
		
	}
	
	
//	DELETING HOSTEL ROOM DEPENDING ON ID
	@DeleteMapping("/api/deleteHostelRoomById/{room_id}")
	public void deleteHostelRoomById(@PathVariable("room_id") Long roomId) 
			throws NotFoundException, SuccessMessageException {
		LOGGER.info("Inside of DeleteHostelRoomById of HostelRoomController.");
		hostelRoomService.deleteHostelRoomById(roomId);
	}
	
	
//	UPDATING HOSTEL ROOM DEPENDING ON ID
	@PutMapping("/api/updateHostelRoom/{room_id}")
	public void updateHostelRoom(@PathVariable("room_id") Long roomId, 
			@RequestBody HostelRoom hostelRoom) 
			throws NotFoundException, SuccessMessageException {
		LOGGER.info("Inside updateHostelRoom of HostelRoomController.");
		hostelRoomService.updateHostelRoom(roomId, hostelRoom);
	}
}
