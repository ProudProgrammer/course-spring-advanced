package hu.course.spring.advanced.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@Autowired
	private Logger logger;
	
	@RequestMapping("helloRest")
	public String helloRest() {
		logger.info(">> helloRest()");
		return "Hello REST";
	}
}
