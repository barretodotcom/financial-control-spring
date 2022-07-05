package com.financial.control.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financial.control.models.Bill;

public interface BillsRepository extends JpaRepository<Bill, UUID> {
	
	List<Bill> findByUserId(UUID userId);
}
