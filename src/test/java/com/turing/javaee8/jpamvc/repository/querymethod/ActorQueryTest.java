package com.turing.javaee8.jpamvc.repository.querymethod;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.turing.javaee8.jpamvc.repository.ActorDao;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Rollback(false)
@SpringBootTest
@Slf4j
public class ActorQueryTest {
	@Autowired
	ActorDao actorDao;
	
	@Test
	@Transactional
	public void getAllGenders(){
		List<String> genders = this.actorDao.getAllGenders();
		genders.forEach(System.err::println);
	}
}
