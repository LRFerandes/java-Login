package org.Login.bussines.service;

import java.security.SecureRandom;
import java.util.Random;

import org.Login.model.entity.UserLogin;
import org.Login.model.repositories.UserRepository;
import org.Login.presentation.DTO.RecoverPasswordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class RecoverPassword {
	@Autowired
	private EmailService emailService;
	
	 @Autowired
	 private UserRepository userRepository;
	
	   private static final String CARACTERES_PERMITIDOS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	   public static String gerarSenha() {
	        StringBuilder senha = new StringBuilder();
	        Random random = new SecureRandom();
	        
	        // Gera a senha com tamanho 10 usando caracteres aleatórios do conjunto permitido
	        for (int i = 0; i < 6; i++) {
	            int indice = random.nextInt(CARACTERES_PERMITIDOS.length());
	            senha.append(CARACTERES_PERMITIDOS.charAt(indice));
	        }
	        
	        return senha.toString();
	    }
	   
	   public ResponseEntity<Object> recoverPassword(RecoverPasswordDto dto) {
			UserLogin user = (UserLogin) this.userRepository.findByEmail(dto.getEmail());
			String codigoAcesso = gerarSenha();
			String encryptedPassword = new BCryptPasswordEncoder().encode(codigoAcesso);
			user.setPassword(encryptedPassword);
			
			String email = emailService.enviarEmailTexto(user.getEmail(), "Código de Acesso", "Sua nova palavra de acesso: " + codigoAcesso);
			
			this.userRepository.save(user);
			
			 return ResponseEntity.ok().build();
		}
	   
	   
	   
}
