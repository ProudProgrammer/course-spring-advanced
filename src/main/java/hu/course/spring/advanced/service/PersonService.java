package hu.course.spring.advanced.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.course.spring.advanced.model.Person;

@Service
public class PersonService {

	@Autowired
	private Logger logger;
	
	public void save(Person person) {
		logger.info(">> save(" + person + ")");
	}
	
	public Person findOne(Integer id) {
		logger.info(">> findOne(" + id + ")");
		return new Person(id, "Bob");
	}
}
