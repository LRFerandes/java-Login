package org.Login.presentation.Controller;

import java.util.List;

import org.Login.bussines.service.UserService;
import org.Login.presentation.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;









@RestController
@RequestMapping("/Login")
public class ControllerUser {
	
	@Autowired
	private UserService servicos;
	
	@PostMapping("/criar")
    public ResponseEntity Criar(@RequestBody UserDTO dto){
        try {
            return new ResponseEntity(servicos.create(dto), HttpStatus.CREATED) ;
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
	
	@GetMapping("/listar")
	public ResponseEntity listarTodos() {
	 try {
		 	List<UserDTO> lista = servicos.read();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
	}
	
    @PutMapping("/UserLogin/{id}")
    public ResponseEntity update(@RequestBody UserDTO Dto, @PathVariable Integer id) {
        try {
            return new ResponseEntity<>(servicos.update(id,Dto), HttpStatus.OK);
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity deletar(@PathVariable Integer id) {
	        try {
	        	servicos.delete(id);
	            return new ResponseEntity<>("deleted successful.", HttpStatus.OK);
	        }catch (Exception e){
	            return  ResponseEntity.badRequest().body(e.getMessage());
	        }
		}
	
	
	

}
