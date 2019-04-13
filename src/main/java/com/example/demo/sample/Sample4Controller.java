package com.example.demo.sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.data.Person;
import com.example.demo.repository.PersonRepository;

@Controller
public class Sample4Controller {
	@Autowired
	PersonRepository repository;
	
	
	@RequestMapping(value="/sample4", method=RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
		Iterable<Person> list = repository.findAll();
 		mav.addObject("data", list);
		mav.setViewName("sample4");
        return mav;
    }
}
