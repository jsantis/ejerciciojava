package com.nisum.ejercicio.dto;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String password;
	private List<PhoneDTO> phones;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<PhoneDTO> getPhones() {
		return phones;
	}
	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}
	
}
