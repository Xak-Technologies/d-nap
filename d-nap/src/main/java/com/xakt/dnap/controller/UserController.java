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
import com.xakt.dnap.repository.UserRepository;
import com.xakt.dnap.service.UserService;

import jakarta.validation.Valid;


@RestController
public class UserController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(UserRepository.class);
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/api/saveUser")
	public User saveUser(@Valid @RequestBody User user) {
		LOGGER.info("Inside saveUser of UserController.");
		return userService.saveUser(user);
	}
	
	
	@GetMapping("/api/fetchUsers")
	public List<User> fetchUsers() {
		LOGGER.info("Inside fetchUsers of UserController.");
		return userService.fetchUsers();
	}
	
	 
	@GetMapping("/api/fetchSingleUser/{user_id}")
	public User fetchSingleUser(@PathVariable("user_id") Long userId) {
		LOGGER.info("Inside fetchSingleUser of UserController.");
		return userService.fetchSingleUser(userId);
	}
	
	
	@DeleteMapping("/api/deleteUser/{user_id}")
	public String deleteUser(@PathVariable("user_id") Long id) {
		LOGGER.info("Inside deleteUser of UserController.");
		userService.deleteUser(id);		
		return "User deleted successfully."; 
	}
	
	
	@PutMapping("/api/editUser/{user_id}")
	public User editUser(@PathVariable("user_id") Long Id, @RequestBody User user) {
		LOGGER.info("Inside editUser of UserController.");
		return userService.editUser(Id, user);
	}

}
