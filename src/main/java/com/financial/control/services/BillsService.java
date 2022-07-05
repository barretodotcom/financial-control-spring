package com.financial.control.services;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.financial.control.exceptions.AppExceptionError;
import com.financial.control.models.Bill;
import com.financial.control.models.User;
import com.financial.control.repositories.BillsRepository;
import com.financial.control.repositories.UsersRepository;

@Service
public class BillsService {
	
	public BillsRepository billsRepository;
	
	public UsersRepository usersRepository;

	public BillsService(BillsRepository billsRepository, UsersRepository usersRepository) {
		this.billsRepository = billsRepository;
		this.usersRepository = usersRepository;
	}
	
	@Transactional
	public Bill createBill(Bill bill) {
		
		if(bill.getPrice() < 0) {
			throw new AppExceptionError("Insira um valor válido");
		}
		
		return this.billsRepository.save(bill);
	}
	
	@Transactional
	public String deleteBill(UUID uuid) {
		
		Bill bill = this.billsRepository.getReferenceById(uuid);
		
		if(bill == null) {
			throw new AppExceptionError("Conta não existente");
		}
		this.billsRepository.deleteById(uuid);
		
		return "Conta deletada com sucesso";
	}
	
	@Transactional
	public Bill updateBill(Bill newBill) {
		try {
			Bill bill = this.billsRepository.getReferenceById(newBill.getId());
			
			bill.setDescription(newBill.getDescription());
			bill.setPrice(newBill.getPrice());
			bill.setTitle(newBill.getTitle());
			
			return this.billsRepository.save(bill);
		}
		catch(Throwable e){
			throw new AppExceptionError("Conta não encontrada");
		}
	}
	
	@Transactional
	public List<Bill> listBillsByUserId(UUID uuid){
		
		try {
			
			User userExists = this.usersRepository.getReferenceById(uuid);

			return this.billsRepository.findByUserId(userExists.getId());
		}
		catch (Throwable e){
			throw new AppExceptionError("Usuário não existente.");
		}
		
	}
	
}
