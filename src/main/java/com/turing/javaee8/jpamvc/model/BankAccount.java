package com.turing.javaee8.jpamvc.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
//@ToString
@Entity
public class BankAccount extends BaseEntity{

	@Column
	private String accountName;
	
	@Column
	private Long balance;
}
