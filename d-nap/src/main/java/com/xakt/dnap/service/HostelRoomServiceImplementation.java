package com.xakt.dnap.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xakt.dnap.entity.HostelRoom;
import com.xakt.dnap.error.BlankFieldException;
import com.xakt.dnap.error.NotFoundException;
import com.xakt.dnap.error.SuccessMessageException;
import com.xakt.dnap.repository.HostelRoomRepository;

import jakarta.validation.Valid;

@Service
public class HostelRoomServiceImplementation implements HostelRoomService{
	
	@Autowired
	HostelRoomRepository hostelRoomRepository;

	@Override
	public void addNewHostelRoom(@Valid HostelRoom hostelRoom) 
			throws BlankFieldException, SuccessMessageException {
		
		if(Objects.isNull(hostelRoom.getRoomCategory()) || 
				"".equalsIgnoreCase(hostelRoom.getRoomCategory())) {
			throw new BlankFieldException("Please add room category.");			
		}
		
		if(Objects.isNull(hostelRoom.getFloor()) || 
				"".equalsIgnoreCase(hostelRoom.getFloor())) {
			throw new BlankFieldException("Please add hostel floor.");			
		}
		
		if(Objects.isNull(hostelRoom.getRoomNumber()) || 
				"".equalsIgnoreCase(hostelRoom.getRoomNumber())) {
			throw new BlankFieldException("Please add room number.");			
		}
		
		if(Objects.isNull(hostelRoom.getRoomLength()) || 
				"".equalsIgnoreCase(hostelRoom.getRoomLength())) {
			throw new BlankFieldException("Please add room length.");			
		}
		
		if(Objects.isNull(hostelRoom.getRoomWidth()) || 
				"".equalsIgnoreCase(hostelRoom.getRoomWidth())) {
			throw new BlankFieldException("Please add room width.");			
		}
		
		if(Objects.isNull(hostelRoom.getRoomPrice()) || 
				"".equalsIgnoreCase(hostelRoom.getRoomPrice())) {
			throw new BlankFieldException("Please add room length.");			
		}		
		hostelRoomRepository.save(hostelRoom);
		throw new SuccessMessageException("Hostel room has been saved successfully.");
	}
	
	

	@Override
	public List<HostelRoom> fetchHostelRooms() throws NotFoundException {
		List<HostelRoom> hostelRoomDB =  hostelRoomRepository.findAll();
		if(hostelRoomDB.isEmpty()) {
			throw new NotFoundException("Not room found.");
		}		
		return hostelRoomDB;
	}



	@Override
	public Optional<HostelRoom> findHostelRoomById(Long roomId) throws NotFoundException {
		@SuppressWarnings("null")
		Optional<HostelRoom> hostelRoomDB = hostelRoomRepository.findById(roomId);
		if(!hostelRoomDB.isPresent()) {
			throw new NotFoundException("Room not found.");
		}
		return hostelRoomDB;
	}



	@SuppressWarnings("null")
	@Override
	public void deleteHostelRoomById(Long roomId) throws NotFoundException, SuccessMessageException {
		Optional<HostelRoom> hostelRoomDB = hostelRoomRepository.findById(roomId);
		if(!hostelRoomDB.isPresent()) {
			throw new NotFoundException("Room is not found");
		}
		
		hostelRoomRepository.deleteById(roomId);
		throw new SuccessMessageException("Room has been deleted successfully.");
		
	}



	@SuppressWarnings("null")
	@Override
	public void updateHostelRoom(Long roomId, HostelRoom hostelRoom) 
			throws NotFoundException, SuccessMessageException {
		@SuppressWarnings("null")
		Optional<HostelRoom> hostelRoomDB = hostelRoomRepository.findById(roomId);
		if(!hostelRoomDB.isPresent()) {
			throw new NotFoundException("Room not found");
		}		
		
		@SuppressWarnings("null")
		HostelRoom hostelRoomDBUpdate = hostelRoomRepository.findById(roomId).get();
		
		if(Objects.nonNull(hostelRoom.getRoomCategory()) && 
				!"".equalsIgnoreCase(hostelRoom.getRoomCategory())) {
			hostelRoomDBUpdate.setRoomCategory(hostelRoom.getRoomCategory());
		}
		
		if(Objects.nonNull(hostelRoom.getFloor()) && 
				!"".equalsIgnoreCase(hostelRoom.getFloor())) {
			hostelRoomDBUpdate.setFloor(hostelRoom.getFloor());
		}
		
		
		if(Objects.nonNull(hostelRoom.getRoomNumber()) && 
				!"".equalsIgnoreCase(hostelRoom.getRoomNumber())) {
			hostelRoomDBUpdate.setRoomNumber(hostelRoom.getRoomNumber());
		}
		
		if(Objects.nonNull(hostelRoom.getRoomLength()) && 
				!"".equalsIgnoreCase(hostelRoom.getRoomLength())) {
			hostelRoomDBUpdate.setRoomLength(hostelRoom.getRoomLength());
		}
		
		if(Objects.nonNull(hostelRoom.getRoomWidth()) && 
				!"".equalsIgnoreCase(hostelRoom.getRoomWidth())) {
			hostelRoomDBUpdate.setRoomWidth(hostelRoom.getRoomWidth());
		}
		
		if(Objects.nonNull(hostelRoom.getKitchen())) {
			hostelRoomDBUpdate.setKitchen(hostelRoom.getKitchen());
		}
		
		if(Objects.nonNull(hostelRoom.getShowerRoom())) {
			hostelRoomDBUpdate.setShowerRoom(hostelRoom.getShowerRoom());
		}
		
		if(Objects.nonNull(hostelRoom.getToilet())) {
			hostelRoomDBUpdate.setToilet(hostelRoom.getToilet());
		}
		
		if(Objects.nonNull(hostelRoom.getRoomPrice()) && 
				!"".equalsIgnoreCase(hostelRoom.getRoomPrice())) {
			hostelRoomDBUpdate.setRoomPrice(hostelRoom.getRoomPrice());
		}
		
		hostelRoomRepository.save(hostelRoomDBUpdate);
		throw new SuccessMessageException("Room information has been updated successfully.");
		
	}

}
