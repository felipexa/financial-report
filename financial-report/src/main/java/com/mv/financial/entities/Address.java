package com.mv.financial.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String street;
	private String number;
	private String complement;
	private String district;
	private String city;
	private String UF;
	private int CEP;	
	
	@OneToOne(mappedBy = "address")
	private Person person;

}
