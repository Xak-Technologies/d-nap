package com.xakt.dnap.service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xakt.dnap.entity.User;
import com.xakt.dnap.error.UserNotFoundException;
import com.xakt.dnap.repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User saveUser(@Valid User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> fetchUsers() {
		return userRepository.findAll();
	}

	@Override
	public User fetchSingleUser(Long Id) throws UserNotFoundException {
		Optional <User> user = userRepository.findById(Id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found.");
		}
		
		return user.get();
	}

	@Override
	public void deleteUser(Long id) throws UserNotFoundException {
		
		Optional <User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		
		userRepository.deleteById(id);
	
	}

	@Override
	public User editUser(Long Id, User user) {
		
		User userDB = userRepository.findById(Id).get();
		
		if(Objects.nonNull(user.getFirstName()) && !"".equalsIgnoreCase(user.getFirstName())) {
			userDB.setFirstName(user.getFirstName());
		}
		
		if(Objects.nonNull(user.getLastName()) && !"".equalsIgnoreCase(user.getLastName())) {
			userDB.setLastName(user.getLastName());
		}
		
		if(Objects.nonNull(user.getOtherNames()) && !"".equalsIgnoreCase(user.getOtherNames())) {
			userDB.setOtherNames(user.getOtherNames());
		}
		
		if(Objects.nonNull(user.getUserEmail()) && !"".equalsIgnoreCase(user.getUserEmail())) {
			userDB.setUserEmail(user.getUserEmail());
		}
		
		if(Objects.nonNull(user.getUserTelephone()) && !"".equalsIgnoreCase(user.getUserTelephone())) {
			userDB.setUserTelephone(user.getUserTelephone());
		}
		
		if(Objects.nonNull(user.getUserPassword()) && !"".equalsIgnoreCase(user.getUserPassword())) {
			userDB.setUserPassword(user.getUserPassword());
		}
		
		if(Objects.nonNull(user.getUserCategory()) && !"".equalsIgnoreCase(user.getUserCategory())) {
			userDB.setUserCategory(user.getUserCategory());
		}
		
		return userRepository.save(userDB);
	}

	@Override
	public List<User> findByFirstName(String firstName) {
		return userRepository.findByFirstName(firstName);
	}

		
	
}
