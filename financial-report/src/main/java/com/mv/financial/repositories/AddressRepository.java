package com.mv.financial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mv.financial.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>  {

}
