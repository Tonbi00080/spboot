package com.example.demo.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.data.Person;
import com.example.demo.repository.PersonRepository;

@Controller
public class Sample5Controller {
	@Autowired
	PersonRepository repository;

	@RequestMapping(value = "/sample5", method = RequestMethod.GET)
	public ModelAndView index(@ModelAttribute("formModel") Person person, 
			ModelAndView mav) {
		mav.addObject("formModel", person);
		Iterable<Person> list = repository.findAll();
		mav.addObject("data", list);
		mav.setViewName("sample5");
		return mav;
	}

	@RequestMapping(value = "/sample5", method = RequestMethod.POST)
	public ModelAndView form(
			@ModelAttribute("formModel") @Validated Person person, 
			BindingResult result,
			ModelAndView mav) {
		if(!result.hasErrors()) {
			repository.saveAndFlush(person);

		} else {
			mav.addObject("msg", "error is occurred.");
		}
		mav.addObject("formModel", person);
		Iterable<Person> list = repository.findAll();
		mav.addObject("data", list);
		mav.setViewName("sample5");
		return mav;

	}

}
