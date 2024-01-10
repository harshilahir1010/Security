package com.einfo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.einfo.demo.dto.LoginDto;
import com.einfo.demo.service.JwtService;



@RestController
public class AuthenticationController {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody LoginDto dto)throws Exception {
	    Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getName(), dto.getPassword()));
	    if(authentication.isAuthenticated()) {
	    	return jwtService.generateToken(dto.getName());
	    }else
	    {
	    	throw new UsernameNotFoundException("invalid user request");
	    }
		
		
	}

}
