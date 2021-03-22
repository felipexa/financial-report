package com.mv.financial.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mv.financial.entities.Account;
import com.mv.financial.repositories.AccountRepository;
import com.mv.financial.services.exception.DatabaseException;
import com.mv.financial.services.exception.ResourceNotFoundException;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repository;
	
	public List<Account> findAll() {
		return repository.findAll();
	}
	
	public Account findById(Long id) {
		Optional<Account> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Account insert(Account obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);		
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Account update(Long id, Account obj) {
		try {
			Account entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);			
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}
	
	private void updateData(Account entity, Account obj) {		
		entity.setCredit(obj.getCredit());
		entity.setDebit(obj.getDebit());
		entity.setTotal(obj.getTotal());
		entity.setTax(obj.getTax());
		entity.setBalance(obj.getBalance());
		entity.setPeriod(obj.getPeriod());
	}
		
}
