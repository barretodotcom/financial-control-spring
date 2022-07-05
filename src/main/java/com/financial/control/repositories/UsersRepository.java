package com.financial.control.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financial.control.models.User;

public interface UsersRepository extends JpaRepository<User, UUID>{

	User findByEmail(String email);
	
}
