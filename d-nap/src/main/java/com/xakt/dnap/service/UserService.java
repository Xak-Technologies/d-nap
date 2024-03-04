package com.xakt.dnap.service;

import java.util.List;

import com.xakt.dnap.entity.User;
import com.xakt.dnap.error.UserNotFoundException;

import jakarta.validation.Valid;

public interface UserService {

	public User saveUser(@Valid User user);

	public List<User> fetchUsers();

	public User fetchSingleUser(Long userId) throws UserNotFoundException;

	public void deleteUser(Long id) throws UserNotFoundException;

	public User editUser(Long Id, User user);

	public List<User> findByFirstName(String firstName);
}
