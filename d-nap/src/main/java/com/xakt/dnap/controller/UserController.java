package com.xakt.dnap.controller;

import java.util.List;

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

import com.xakt.dnap.entity.User;
import com.xakt.dnap.error.AlreadyExistsException;
import com.xakt.dnap.error.BlankFieldException;
import com.xakt.dnap.error.NotFoundException;
import com.xakt.dnap.error.SuccessMessageException;
import com.xakt.dnap.repository.UserRepository;
import com.xakt.dnap.service.LandlordService;
import com.xakt.dnap.service.UserService;


@RestController
public class UserController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(UserRepository.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	LandlordService landlordService;
	
	
	@PostMapping("/api/saveUser")
	public void saveUser(@RequestBody User user) throws BlankFieldException, SuccessMessageException, AlreadyExistsException {
		LOGGER.info("Inside saveUser of UserController.");
		userService.saveUser(user);
	}
	
	
	@GetMapping("/api/fetchUsers")
	public List<User> fetchUsers() throws NotFoundException {
		LOGGER.info("Inside fetchUsers of UserController.");
		return userService.fetchUsers();
	}
	
	 
	@GetMapping("/api/fetchSingleUser/{user_id}")
	public User fetchSingleUser(@PathVariable("user_id") Long userId) throws NotFoundException {
		LOGGER.info("Inside fetchSingleUser of UserController.");
		return userService.fetchSingleUser(userId);
	}
	
	
	@DeleteMapping("/api/deleteUser/{user_id}")
	public void deleteUser(@PathVariable("user_id") Long id) throws NotFoundException, SuccessMessageException {
		LOGGER.info("Inside deleteUser of UserController.");
		userService.deleteUser(id);		
		
	}
	
	
	@PutMapping("/api/editUser/{user_id}")
	public void editUser(@PathVariable("user_id") Long Id, @RequestBody User user) throws NotFoundException, BlankFieldException, SuccessMessageException  {
		LOGGER.info("Inside editUser of UserController.");
		userService.editUser(Id, user);
	}

}
