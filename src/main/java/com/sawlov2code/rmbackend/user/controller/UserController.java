package com.sawlov2code.rmbackend.user.controller;


import com.sawlov2code.rmbackend.security.service.JwtService;
import com.sawlov2code.rmbackend.user.model.Users;
import com.sawlov2code.rmbackend.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private JwtService jwtService;

	@Autowired
	AuthenticationManager authenticationManager;


	@GetMapping("/register")
	public String showRegisterForm() {
		return "register";
	}

	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}



	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
	  return service.saveUser(user);
	}

	@PostMapping("/login")
	public String login(@RequestBody Users user){

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

		if(authentication.isAuthenticated())
			return jwtService.generateToken(user.getUsername());
		else
			return "Login Failed";

	}




}
