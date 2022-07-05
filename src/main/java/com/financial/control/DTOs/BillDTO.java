package com.financial.control.DTOs;

import java.util.UUID;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
public class BillDTO {
	
	public double price;
	
	@NotBlank
	public String title;
	
	@NotBlank
	public String description;
	
	public UUID userId;
}
