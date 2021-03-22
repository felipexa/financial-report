package com.mv.financial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mv.financial.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
