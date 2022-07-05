package com.financial.control.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.financial.control.exceptions.AppExceptionError;
import com.financial.control.models.User;
import com.financial.control.repositories.UsersRepository;

@Service
public class UsersService {
	
	public UsersRepository usersRepository;
	
	public BCryptPasswordEncoder passwordEncoder;
	
	public UsersService(UsersRepository usersRepository, BCryptPasswordEncoder passwordEncoder) {
		this.usersRepository = usersRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Transactional
	public User createUser(User user) {
		
		User userExists = this.usersRepository.findByEmail(user.getEmail());
		
		if(userExists != null) {
			throw new AppExceptionError("E-mail is already registered.");
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		User createdUser = this.usersRepository.save(user);
		
		return createdUser;
		
	}
	
	@Transactional
	public List<User> list(){
		return this.usersRepository.findAll();
	}
	
}
