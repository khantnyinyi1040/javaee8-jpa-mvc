package com.turing.javaee8.jpamvc.model;

import java.util.Date;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@MappedSuperclass
public class Human extends BaseEntity{
	@Column
	String firstName;
	
	@Column
	String lastName;
	
	@Formula("concat(first_name, ' ', last_name)")
	private String fullName;

	
	@Column
	Date birthday;
	
	@Formula("TIMESTAMPDIFF(YEAR, birthday, CURDATE())")
	private Integer age;
	
	@Enumerated(EnumType.ORDINAL)
	@Column
	Gender gender;
}
