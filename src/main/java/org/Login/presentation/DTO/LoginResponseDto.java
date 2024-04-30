package org.Login.presentation.DTO;

public class LoginResponseDto {
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

	public LoginResponseDto() {
		super();
	}

	public LoginResponseDto(String token) {
		super();
		this.token = token;
	}
	
	
}
