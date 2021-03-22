package com.mv.financial.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mv.financial.entities.Address;
import com.mv.financial.repositories.AddressRepository;
import com.mv.financial.services.exception.DatabaseException;
import com.mv.financial.services.exception.ResourceNotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;
	
	public List<Address> findAll() {
		return repository.findAll();
	}
	
	public Address findById(Long id) {
		Optional<Address> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	} 
	
	public Address insert(Address obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Address update(Long id, Address obj) {
		try {
			Address entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	 
	private void updateData(Address entity, Address obj) {		
		entity.setStreet(obj.getStreet());
		entity.setNumber(obj.getNumber());
		entity.setComplement(obj.getComplement());
		entity.setDistrict(obj.getDistrict());
		entity.setCity(obj.getCity());
		entity.setUF(obj.getUF());
		entity.setCEP(obj.getCEP());		
	}
}
