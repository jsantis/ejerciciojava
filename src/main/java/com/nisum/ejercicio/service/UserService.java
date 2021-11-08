package com.nisum.ejercicio.service;

import java.util.List;

import com.nisum.ejercicio.dto.UserDTO;
import com.nisum.ejercicio.dto.UserResponseDTO;
import com.nisum.ejercicio.model.User;

public interface UserService {

	boolean validateEmail(UserDTO userDTO);
	
	List<User> getUsers();
	
	List<User> getUsersbyEmail(String email);
	
	boolean exitEmail(UserDTO userDTO);
	
	boolean validatePassword(UserDTO userDTO);
	
	UserResponseDTO saveUser(UserDTO userDTO) throws Exception;
	

}
