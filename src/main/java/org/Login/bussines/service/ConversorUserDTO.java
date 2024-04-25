package org.Login.bussines.service;

import org.Login.model.entity.UserLogin;
import org.Login.presentation.DTO.UserDTO;
import org.springframework.stereotype.Service;



@Service
public class ConversorUserDTO {
	
	public UserDTO ObjToDto(UserLogin user) {
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setEmail(user.getEmail());
		dto.setName(user.getName());
		return dto;
	}
	
	public UserLogin DtoToObj(UserDTO dto) {
		UserLogin user = new UserLogin();
		user.setId(dto.getId());
		user.setEmail(dto.getEmail());
		user.setName(dto.getName());
		return user;
	}
}
