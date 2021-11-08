package com.nisum.ejercicio.dao;

import java.util.List;

import com.nisum.ejercicio.model.User;

public interface UserDao {

	List<User> getUsers();
	
	List<User> getUsersbyEmail(String email);
	
	User saveUser(User user);
}
