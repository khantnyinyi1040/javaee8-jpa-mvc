package com.turing.javaee8.jpamvc.repository;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.turing.javaee8.jpamvc.model.Actor;
import com.turing.javaee8.jpamvc.model.Gender;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class ActorDaoTest {

	@Autowired
	ActorDao actorDao;
	
	//@Test
	public void testSaveActor() {
		
		Actor actor = new Actor();
		
		actor.setFirstName("Sai");
		actor.setLastName("Sai Khang Hlaing");
		Date birthDate = new GregorianCalendar(1975, 10, 5).getTime();
		actor.setBirthday(birthDate);
		actor.setGender(Gender.Female);
		
		this.actorDao.save(actor);
		
	}
	@Test
	public void testFindAll() {
		List<Actor> actors = this.actorDao.findAll();
		actors.forEach(System.out::println);
		
		
	}
}
