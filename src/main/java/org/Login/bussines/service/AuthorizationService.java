package org.Login.bussines.service;

import java.sql.Date;

import org.Login.bussines.security.TokenService;
import org.Login.model.entity.UserLogin;
import org.Login.model.repositories.UserRepository;
import org.Login.presentation.DTO.AuthetinticationDto;
import org.Login.presentation.DTO.LoginResponseDto;
import org.Login.presentation.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthorizationService implements UserDetailsService{
    @Autowired
    private ApplicationContext context;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    private AuthenticationManager authenticationManager;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    } 

    public ResponseEntity<Object> login( @Validated @RequestBody  AuthetinticationDto data){
        authenticationManager = context.getBean(AuthenticationManager.class);

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UserLogin) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDto(token));
    }


    public ResponseEntity<Object> register (@RequestBody UserDTO registerDto){
        if (this.userRepository.findByEmail(registerDto.getEmail()) != null ) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDto.getPassword());
        
        UserLogin newUser = new UserLogin(registerDto.getName(),registerDto.getEmail(), encryptedPassword, registerDto.getRole());
        newUser.setCreatedAt(new Date(System.currentTimeMillis()));
        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }



    
}