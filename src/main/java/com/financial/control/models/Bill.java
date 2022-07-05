package com.financial.control.models;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public UUID id;
	
	@Column
	public double price;
	
	@Column
	public String title;
	
	@Column
	public String description;
	
	@Column
	public LocalDateTime createdAt;
	
	@Column
	public UUID userId;
}
