package org.Login.presentation.DTO;

import java.util.Objects;

import org.Login.model.enums.UserRole;
import org.antlr.v4.runtime.misc.NotNull;

public class UserDTO {
	
	private String name;
	@NotNull
	private String email;
	@NotNull
	private String password;
	@NotNull
	private UserRole role;
	
	public UserDTO(String name,String email, String password, UserRole role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public UserDTO() {
		super();
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

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	
}
