package com.xakt.dnap.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xakt.dnap.entity.ShopRoom;
import com.xakt.dnap.error.BlankFieldException;
import com.xakt.dnap.error.NotFoundException;
import com.xakt.dnap.error.SuccessMessageException;
import com.xakt.dnap.service.ShopRoomService;

@RestController
public class ShopRoomController {
	
	@Autowired
	ShopRoomService shopRoomService;
	
	
	private final Logger LOGGER = LoggerFactory.getLogger(ShopRoomController.class);
	

/*
 * ADDING A NEW SHOP ROOM
 */
	@PostMapping("/api/addNewShopRoom")
	public void addNewShopRoom(@RequestBody ShopRoom shopRoom) 
			throws BlankFieldException, SuccessMessageException {
		LOGGER.info("Inside addNewShopRoom of ShopRoomController.");
		
		shopRoomService.addNewShopRoom(shopRoom);
	}
	
	
/*
 * FETCHING A LIST OF SHOP ROOMS
 */
	
	@GetMapping("/api/fetchShopRooms")
	public List<ShopRoom> fetchShopRooms() throws NotFoundException{
		LOGGER.info("Inside fetchShopRooms of ShopRoomController.");
		return shopRoomService.fetchShopRooms();
	}
	
	
/*
 *DELETING SHOP ROOM BY ID
 */
	@DeleteMapping("/api/deleteShopRoom/{room_id}")
	public void deleteShopRoom(@PathVariable("room_id") Long roomId) 
			throws NotFoundException, SuccessMessageException {
		LOGGER.info("Inside deleteShopRoom of ShopRoomController.");
		shopRoomService.deleteShopRoom(roomId);
		
	}

}
