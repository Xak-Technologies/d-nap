package com.xakt.dnap.service;

import java.util.List;

import com.xakt.dnap.entity.User;
import com.xakt.dnap.error.AlreadyExistsException;
import com.xakt.dnap.error.BlankFieldException;
import com.xakt.dnap.error.NotFoundException;
import com.xakt.dnap.error.SuccessMessageException;

import jakarta.validation.Valid;

public interface UserService {

	public void saveUser(@Valid User user) throws BlankFieldException, SuccessMessageException, AlreadyExistsException;

	public List<User> fetchUsers() throws NotFoundException;

	public User fetchSingleUser(Long userId) throws NotFoundException;

	public void deleteUser(Long id) throws NotFoundException, SuccessMessageException;

	public void editUser(Long Id, User user) throws NotFoundException, BlankFieldException, SuccessMessageException ;

}
