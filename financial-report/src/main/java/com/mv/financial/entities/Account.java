package com.mv.financial.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double credit;
	private double debit;
	private double total;
	private double rate;
	private double balance;
	private Date period;
	
	@ManyToOne
	private Person person;

}
