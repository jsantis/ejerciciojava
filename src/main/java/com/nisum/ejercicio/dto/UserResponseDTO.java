package com.nisum.ejercicio.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class UserResponseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date created;
	private Date modified;
	private Date last_login;
	private UUID token;
	private boolean isactive;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Date getLastLogin() {
		return last_login;
	}
	public void setLastLogin(Date lastLogin) {
		this.last_login = lastLogin;
	}
	public UUID getToken() {
		return token;
	}
	public void setToken(UUID token) {
		this.token = token;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	
	
	
	

}
