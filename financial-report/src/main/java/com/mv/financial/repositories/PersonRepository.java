package com.mv.financial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mv.financial.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>  {

}
