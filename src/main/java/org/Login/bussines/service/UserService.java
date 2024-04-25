package org.Login.bussines.service;

import java.util.List;
import java.util.stream.Collectors;

import org.Login.model.entity.UserLogin;
import org.Login.model.repositories.UserRepository;
import org.Login.presentation.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class UserService {
	@Autowired
	private UserRepository repositorio;
	@Autowired
	private ConversorUserDTO conversor;
	
	
	public UserDTO create(UserDTO dto) {
		UserLogin user = conversor.DtoToObj(dto);
		repositorio.save(user);
		return conversor.ObjToDto(user);
	}
	
	public List<UserDTO> read(){
		List<UserLogin> lista = repositorio.findAll();
		
		List<UserDTO> listaDto = lista.stream()
                .map(DiaDaSemana -> conversor.ObjToDto(DiaDaSemana))
                .collect(Collectors.toList());
		
		
		return listaDto;
	}
	
	public void delete(Integer id) {
		repositorio.deleteById(id);
	}
	
	public UserDTO update(Integer id, UserDTO dto) {
		UserLogin user = repositorio.findById(id).orElse(null);
		user.setEmail(dto.getEmail());
		user.setName(dto.getName());
		repositorio.save(user);
		
		return conversor.ObjToDto(user);
		
		
	}
}
