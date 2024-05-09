package org.Login.presentation.Controller;

import org.Login.bussines.service.AuthorizationService;
import org.Login.bussines.service.RecoverPassword;
import org.Login.presentation.DTO.AuthetinticationDto;
import org.Login.presentation.DTO.RecoverPasswordDto;
import org.Login.presentation.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	   	@Autowired
	    public AuthorizationService authorizationService;
	   	
	   	@Autowired
	   	public RecoverPassword recoverPassword;
	   	
	   	
	   	

	    @PostMapping("/login")
	    public ResponseEntity<Object> login(@RequestBody @Validated AuthetinticationDto authetinticationDto){
	        return authorizationService.login(authetinticationDto);
	    }


	    @PostMapping("/register")
	    public ResponseEntity<Object> register (@RequestBody UserDTO registerDto){
	        return authorizationService.register(registerDto);
	    }
	    
	    @PostMapping("/recover")
	    public ResponseEntity<Object> recover (@RequestBody RecoverPasswordDto recoverDto){
	        return recoverPassword.recoverPassword(recoverDto);
	    }
	    
}
