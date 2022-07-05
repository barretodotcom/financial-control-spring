package com.financial.control.DTOs;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UsersDTO {

	@NotBlank
	public String firstName;
	
	@NotBlank
	public String lastName;
	
	@NotBlank
	public String email;
	
	@NotBlank
	public String password;
	
	
}
