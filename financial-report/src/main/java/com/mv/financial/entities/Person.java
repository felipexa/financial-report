package com.mv.financial.entities;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typePerson", 
    discriminatorType = DiscriminatorType.STRING)
@Table(name = "tb_person")
public abstract class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String phone;	
	private Date dtRegister;
	
	@OneToOne
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	
	@OneToMany
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private Account account;
	
}
