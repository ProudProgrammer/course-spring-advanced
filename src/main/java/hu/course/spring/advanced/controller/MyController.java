package hu.course.spring.advanced.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hu.course.spring.advanced.model.Person;
import hu.course.spring.advanced.service.PersonService;

@Controller
@RequestMapping("/person")
public class MyController {

	@Autowired
	private Logger logger;

	@Autowired
	private PersonService personService;

	@RequestMapping(value = { "/add", "/edit" }, method = { RequestMethod.POST })
	public String addPerson(@ModelAttribute("person") Person person) {
		logger.info(">> addPerson({})", person);

		personService.save(person);
		return "redirect:view?id=" + person.getId();
	}

	@ModelAttribute("person")
	public Person getPerson(@RequestParam(value = "id", required = false) Integer id) {
		logger.info(">> getPerson({})", id);

		Person person = null;
		if (id != null) {
			person = personService.findOne(id);
		}
		return person == null ? new Person() : person;
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewPersonForm() {
		logger.info(">> viewPersonForm()");

		return "person/view";
	}

	@RequestMapping(value = "/edit", method = { RequestMethod.GET })
	public String showEditForm(Model model) {
		logger.info(">> showEditForm()");
		logger.info("IsPersonAvailable: " + model.containsAttribute("person"));
		
		return "editPerson"; // editPerson view is configured
	}
}
