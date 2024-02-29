package com.xakt.dnap.service;

import java.util.List;

import com.xakt.dnap.entity.User;

import jakarta.validation.Valid;

public interface UserService {

	public User saveUser(@Valid User user);

	public List<User> fetchUsers();

	public User fetchSingleUser(Long userId);

	public void deleteUser(Long id);

	public User editUser(Long Id, User user);
}
