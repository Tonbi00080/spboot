package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.Person;
import com.example.demo.repository.PersonRepository;

@Service
@Transactional
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	/**
	 * 個人データ一覧取得サービス
	 * @return List<Person>
	 */
	public List<Person> findAll(){
		return personRepository.findAll();
	}

	/**
	 * 個人データ取得サービス
	 * @return List<Person>
	 */
	public Optional<Person> findPerson(Integer id){
		return personRepository.findById(id);
	}
	
	/**
	 * 個人データ作成サービス
	 */
	public List<Person> create(List<Person> persons) {
		return personRepository.saveAll(persons);
	}
	
	/**
	 * 商品更新サービス
	 * @param item
	 * @return item
	 */
	public Person update(Person person) {
		return personRepository.save(person);
	}
	
	/**
	 * 個人削除サービス
	 * @param id
	 */
	public void delete(Integer id) {
		personRepository.deleteById(id);
	}

}
