package com.xakt.dnap.service;

import java.util.List;
import java.util.Optional;

import com.xakt.dnap.entity.HostelRoom;
import com.xakt.dnap.error.BlankFieldException;
import com.xakt.dnap.error.NotFoundException;
import com.xakt.dnap.error.SuccessMessageException;

import jakarta.validation.Valid;

public interface HostelRoomService {

	public void addNewHostelRoom(@Valid HostelRoom hostelRoom) 
			throws BlankFieldException, SuccessMessageException;

	List<HostelRoom> fetchHostelRooms() throws NotFoundException;

	Optional<HostelRoom> findHostelRoomById(Long roomId)throws NotFoundException;

	void deleteHostelRoomById(Long roomId) throws NotFoundException, SuccessMessageException;

	void updateHostelRoom(Long roomId, HostelRoom hostelRoom) 
			throws NotFoundException, SuccessMessageException;

}
