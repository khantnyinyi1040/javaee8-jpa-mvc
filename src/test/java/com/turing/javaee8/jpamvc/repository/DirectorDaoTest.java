package com.turing.javaee8.jpamvc.repository;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.turing.javaee8.jpamvc.model.Address;
import com.turing.javaee8.jpamvc.model.Director;
import com.turing.javaee8.jpamvc.model.Gender;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class DirectorDaoTest {

	@Autowired
	DirectorDao directorDao;
	
	//@Test
	public void testSaveDirector() {
		
		Director director = new Director();
		
		director.setFirstName("Aye");
		director.setLastName("Aye Win");
		Date birthDate = new GregorianCalendar(1980, 9, 2).getTime();
		director.setBirthday(birthDate);
		director.setGender(Gender.Female);
		
		this.directorDao.save(director);
		
	}
	//@Test
	public void testFindAll() {
		List<Director> director = this.directorDao.findAll();
		director.forEach(System.out::println);
	}
	
	@Test
	public void testUpdate() {
		Optional<Director> result = this.directorDao.findById(1L);
		Director director = result.get();
		
		Address address = new Address();
		address.setCity("Yangon");
		address.setAddress("Somewhere in Yangon");
		
		director.setAddress(address);
		
		this.directorDao.save(director);
	}
}
