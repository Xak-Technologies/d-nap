package com.xakt.dnap.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xakt.dnap.entity.ShopRoom;
import com.xakt.dnap.error.BlankFieldException;
import com.xakt.dnap.error.NotFoundException;
import com.xakt.dnap.error.SuccessMessageException;
import com.xakt.dnap.repository.ShopRoomRepository;

@Service
public class ShopRoomServiceImplementation implements ShopRoomService {
	
	
	@Autowired
	ShopRoomRepository shopRoomRepository;

/*
 * SAVING A NEW SHOP ROOM
 */
	@Override
	public void addNewShopRoom(ShopRoom shopRoom) 
			throws BlankFieldException, SuccessMessageException {
		
		if(Objects.isNull(shopRoom.getRoomNumber()) || 
				"".equalsIgnoreCase(shopRoom.getRoomNumber())) {
			throw new BlankFieldException("Please add Room number.");
		}
		
		if(Objects.isNull(shopRoom.getRoomLocation()) || 
				"".equalsIgnoreCase(shopRoom.getRoomLocation())) {
			throw new BlankFieldException("Please add Room location.");
		}
		
		if(Objects.isNull(shopRoom.getFloor()) || 
				"".equalsIgnoreCase(shopRoom.getFloor())) {
			throw new BlankFieldException("Please add floor.");
		}
		
		if(Objects.isNull(shopRoom.getRoomLength()) || 
				"".equalsIgnoreCase(shopRoom.getRoomLength())) {
			throw new BlankFieldException("Please add Room length.");
		}
		
		if(Objects.isNull(shopRoom.getRoomWidth()) || 
				"".equalsIgnoreCase(shopRoom.getRoomWidth())) {
			throw new BlankFieldException("Please add Room width.");
		}
		
		if(Objects.isNull(shopRoom.getRoomPrice()) || 
				"".equalsIgnoreCase(shopRoom.getRoomPrice())) {
			throw new BlankFieldException("Please add Room price.");
		}
		
		if(Objects.isNull(shopRoom.getRentParttern()) || 
				"".equalsIgnoreCase(shopRoom.getRentParttern())) {
			throw new BlankFieldException("Please add Rent parttern.");
		}
		
		shopRoomRepository.save(shopRoom);
		throw new SuccessMessageException("Room has been saved successFully.");		
	}	

	
/*
 * FETCHING A LIST OF HOSTEL ROOMS
 */
	@Override
	public List<ShopRoom> fetchShopRooms() throws NotFoundException {
		List<ShopRoom> shopRoomDB = shopRoomRepository.findAll();
		if(shopRoomDB.isEmpty()) {
			throw new NotFoundException("No shop room was found");
		}
		return shopRoomDB;
	}


/*
 * DELETING A SHOP ROOM BY ID
 */
	@Override
	public void deleteShopRoom(Long roomId) throws NotFoundException, SuccessMessageException {
		Optional<ShopRoom> shopRoomDB = shopRoomRepository.findById(roomId);
		if(!shopRoomDB.isPresent()) {
			throw new NotFoundException("Room not found");
		}
		
		shopRoomRepository.deleteById(roomId);
		throw new SuccessMessageException("Room has been deleted sucessfully.");
		
	}
	

	
	

}
