package com.example.demo.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.Person;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping("api/persons")
public class PersonListController {
	
	@Autowired
	PersonService personService;
	
	/**
	 * 個人登録API
	 * @param person
	 * @return ist<Person>
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	List<Person> postPersons(@RequestBody List<Person> persons) {
		return personService.create(persons);
	}
	
	/**
	 * 個人一覧取得API
	 * @return List<Person>
	 */
	@GetMapping
	List<Person> getPersons() {
		List<Person> persons = personService.findAll();	
		return persons;
	}
	
	/**
	 * 個人取得API
	 * @param id
	 * @return Optional<Person>
	 */
	@GetMapping(path = "{id}")
	Optional<Person> getPerson(@PathVariable Integer id) {
		return personService.findPerson(id);
	}
	
	
	/**
     * 個人更新API
     * @param id
     * @param person
     * @return Person
     */
    @PutMapping(path = "{id}")
    Person putPerson(@PathVariable Integer id, @RequestBody Person person) {
    	person.setId(id);
    	return personService.update(person);
    }
    
    /**
     * 個人削除API
     * @param id
     */
    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteItem(@PathVariable Integer id) {
    	personService.delete(id);
    }
}
