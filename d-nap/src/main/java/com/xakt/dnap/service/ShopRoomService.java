package com.xakt.dnap.service;

import java.util.List;

import com.xakt.dnap.entity.ShopRoom;
import com.xakt.dnap.error.BlankFieldException;
import com.xakt.dnap.error.NotFoundException;
import com.xakt.dnap.error.SuccessMessageException;


public interface ShopRoomService {

	public void addNewShopRoom(ShopRoom shopRoom) throws BlankFieldException, SuccessMessageException;

	public List<ShopRoom> fetchShopRooms() throws NotFoundException;

	public void deleteShopRoom(Long roomId) throws NotFoundException, SuccessMessageException;

}
