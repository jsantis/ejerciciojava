package com.nisum.ejercicio.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.ejercicio.dao.UserDao;
import com.nisum.ejercicio.dto.UserDTO;
import com.nisum.ejercicio.dto.UserResponseDTO;
import com.nisum.ejercicio.model.User;
import com.nisum.ejercicio.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public boolean validateEmail(UserDTO userDTO) {
		
		return EmailValidator.getInstance().isValid(userDTO.getEmail());
	}
	
	public List<User> getUsers() {
		return userDao.getUsers();
	}
	
	public List<User> getUsersbyEmail(String email) {
		return userDao.getUsersbyEmail(email);
	}
	
	public boolean exitEmail(UserDTO userDTO) {
		List<User> userList = this.getUsersbyEmail(userDTO.getEmail());
		return userList != null && !userList.isEmpty();
	}
	
	public boolean validatePassword(UserDTO userDTO) {
		
		if(userDTO.getPassword() == null) return false;
		
		Pattern pat = Pattern.compile("^(?:(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*)[^\\s]{3,}$");
	    Matcher mat = pat.matcher(userDTO.getPassword());                                                                           
	    return mat.matches();
	}
	
	public UserResponseDTO saveUser(UserDTO userDTO) throws Exception {
		
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		
		user = this.userDao.saveUser(user);
		UserResponseDTO userResponseDTO = new UserResponseDTO();
		BeanUtils.copyProperties(user, userResponseDTO);
		return userResponseDTO;
	}
}
