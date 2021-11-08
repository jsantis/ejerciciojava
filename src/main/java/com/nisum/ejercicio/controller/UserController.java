package com.nisum.ejercicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.ejercicio.dto.ResponseDTO;
import com.nisum.ejercicio.dto.UserDTO;
import com.nisum.ejercicio.model.User;
import com.nisum.ejercicio.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {
		
		List<User> userList = userService.getUsers();
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody UserDTO userDTO) {
		
		if (!this.userService.validatePassword(userDTO)) {
			return new ResponseEntity<>(new ResponseDTO("Password format incorrect."), HttpStatus.BAD_REQUEST);
		}
		
		if (!this.userService.validateEmail(userDTO)) {
			return new ResponseEntity<>(new ResponseDTO("Email not valid"), HttpStatus.BAD_REQUEST);
		}

		if (this.userService.exitEmail(userDTO)) {
			return new ResponseEntity<>(new ResponseDTO("Email exit"), HttpStatus.FOUND);
		}
		
		try {
			return new ResponseEntity<>(this.userService.saveUser(userDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseDTO("User error created"), HttpStatus.NOT_MODIFIED);
		}
		
	}

}
