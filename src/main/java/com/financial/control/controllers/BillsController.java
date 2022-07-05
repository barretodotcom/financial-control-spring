package com.financial.control.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financial.control.DTOs.BillDTO;
import com.financial.control.DTOs.UsersDTO;
import com.financial.control.models.Bill;
import com.financial.control.models.User;
import com.financial.control.services.BillsService;

@RestController
@CrossOrigin(origins = "*" ,maxAge = 3600)
@RequestMapping("/bills")
public class BillsController {
	
	public BillsService billsService;
	
	public BillsController(BillsService billsService) {
		this.billsService = billsService;
	}

	@GetMapping(path = "/{uuid}")
	public ResponseEntity<Object> getBills(@PathVariable UUID uuid) {
		return new ResponseEntity<>(this.billsService.listBillsByUserId(uuid), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> createBill(@RequestBody @Valid BillDTO billdto){
		
		Bill bill = new Bill();
		BeanUtils.copyProperties(billdto, bill);
		
		return new ResponseEntity<>(this.billsService.createBill(bill),HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{uuid}")
	public ResponseEntity<Object> deleteBill(@PathVariable UUID uuid){
		return new ResponseEntity<>(this.billsService.deleteBill(uuid), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Object> updateBill(@RequestBody Bill bill){
		return new ResponseEntity<>(this.billsService.updateBill(bill),HttpStatus.OK);
	}
	
}
