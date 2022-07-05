package com.financial.control.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financial.control.DTOs.UsersDTO;
import com.financial.control.models.User;
import com.financial.control.services.UsersService;

@RestController
@CrossOrigin(origins = "*" ,maxAge = 3600)
@RequestMapping("/users")
public class UserController {
	
	public UsersService userService;
	
	public UserController(UsersService userservice) {
		this.userService = userservice;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> post(@RequestBody @Valid UsersDTO userDto){
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		
		return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Object> getUsers(){
		return new ResponseEntity<>(userService.list(), HttpStatus.OK);
	}
	
}
