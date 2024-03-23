package com.xakt.dnap.service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xakt.dnap.entity.Landlord;
import com.xakt.dnap.entity.User;
import com.xakt.dnap.error.AlreadyExistsException;
import com.xakt.dnap.error.BlankFieldException;
import com.xakt.dnap.error.NotFoundException;
import com.xakt.dnap.error.SuccessMessageException;
import com.xakt.dnap.repository.LandlordRepository;
import com.xakt.dnap.repository.UserRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	LandlordRepository landlordRepository;
	
	
/*
 * SAVING A NEW USER TO THE DATABASE 
 * This method;
 * 1.Checks for blank fields and throws a Blank_Field_Exception for each required blank field.
 * 2.Checks for duplicate unique values and throws an AlreadyExistsException for any duplicate unique field
 * If all conditions(Blank field, Duplicate values) are fulfilled, this method return 
 * a User has been saved successfully message to the client side.
 */
	@Override
	public void saveUser(@Valid User user) throws BlankFieldException, SuccessMessageException, AlreadyExistsException {
		
		List<User> userDBEmail = userRepository.findByUserEmail(user.getUserEmail());
		
			
		if(!userDBEmail.isEmpty()) {
			throw new AlreadyExistsException("Email address already used");
		}		
		
		
		if(Objects.isNull(user.getUserEmail()) || "".equalsIgnoreCase(user.getUserEmail())){
			throw new BlankFieldException("Please add user email.");
			
		}
		
		if(Objects.isNull(user.getUserRole()) || "".equalsIgnoreCase(user.getUserRole())){
			throw new BlankFieldException("Please add user role.");
			
		}
		
		if(Objects.isNull(user.getUserPassword()) || "".equalsIgnoreCase(user.getUserPassword())){
			throw new BlankFieldException("Please add user password.");
			
		}
		
		userRepository.save(user);
		throw new SuccessMessageException("User has been saved successfully.");
	}
	
	
	
	
/* 
 * FETCHING THE LIST OF USERS
 * This method fetches the list of users and return the list of users to the client side.
 * If no user found in the database, this method throws a NotFoundException,
 * and return a No User Found message to the client side.
 * If A user or users are found in the database, a users list is returned to the client side.
 */
	@Override
	public List<User> fetchUsers() throws NotFoundException {
		List <User> usersDB = userRepository.findAll();
		
		if(usersDB.isEmpty()) {
			throw new NotFoundException("No User Found.");
		}		
		return usersDB;
	}
	
	
	
/*
 * FETCHING A SINGLE USER DEPENDING ON USER ID
 * This method fetches a single user depending of the passed user ID.
 * If no user found, it throws a NotFoundException a return a No user found message to the 
 * client side.
 * If the user if found, the User Object is return to the client side.
 */
	@SuppressWarnings("null")
	@Override
	public User fetchSingleUser(Long id) throws NotFoundException {
		Optional <User> user = userRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new NotFoundException("User not found.");
		}
		
		return user.get();
	}
	
	
	
	
 /*
  * DELETING A USER
  * This method deletes a user depending on the passed user ID.
  * If the user doesn't exist, it throws a UserNotFoundeException and return a 
  * user not found message to the client side.
  * If the user exists, that particular user is deleted and a user deleted successFully message 
  * to the client side.
  */
	@SuppressWarnings("null")
	@Override
	@Transactional
	public void deleteUser(Long id) throws NotFoundException, SuccessMessageException {	
		
		Optional<User> userDB = userRepository.findByUserId(id);
		if(userDB.isEmpty()) {
			throw new NotFoundException("User not found");
		}
		
		userRepository.deleteByUserId(id);
		throw new SuccessMessageException("User deleted successfully.");
	
	}
	
	
	/*
	 * UPDATING USER INFOMATION
	 */

	@SuppressWarnings("null")
	@Override
	public void editUser(Long Id, User user) throws NotFoundException, SuccessMessageException {
		
		
		Optional<User> userDBExist = userRepository.findById(Id);
		
		if(!userDBExist.isPresent()) {
			throw new NotFoundException("User not Found.");
		}
		
		User userDB = userRepository.findById(Id).get();
		
		
		if(Objects.nonNull(user.getUserEmail()) && !"".equalsIgnoreCase(user.getUserEmail())) {
			userDB.setUserEmail(user.getUserEmail());
		}
		
		if(Objects.nonNull(user.getUserPassword()) && !"".equalsIgnoreCase(user.getUserPassword())) {
			userDB.setUserPassword(user.getUserPassword());
		}
		
		if(Objects.nonNull(user.getUserRole()) && !"".equalsIgnoreCase(user.getUserRole())) {
			userDB.setUserRole(user.getUserRole());
		}
		
		
		userRepository.save(userDB);
		throw new SuccessMessageException("User infomation has been updated successfully.");
	}
		
	
}
