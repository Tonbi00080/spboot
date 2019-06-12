package com.example.demo.sample;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.data.Person;
import com.example.demo.repository.JobMappingRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.JobMappingService;

@Controller
public class Sample5Controller {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private JobMappingRepository jobMappingRepository;
	
	@Autowired
	private JobMappingService jobMappingService;

	@RequestMapping(value = "/sample5", method = RequestMethod.GET)
	public String index(@ModelAttribute("formModel") Person person, 
			Model model) {
		
		List<String> jobTypes = jobMappingRepository.findDistinctJobType();
	    LinkedHashMap<String, String> jobTypeMap = new LinkedHashMap<>();
	    
	    // JobTypeを格納
	    Integer key;
	    for (int i = 0; i < jobTypes.size(); ++i) {
	      key = i;
	      jobTypeMap.put(key.toString(), jobTypes.get(i));
	    }
	    person.setJobTypeMap(jobTypeMap);
		
		model.addAttribute("formModel", person);
		Iterable<Person> list = personRepository.findAll();
		model.addAttribute("data", list);
		return "/sample5";
	}
	
	  /**
	   * 極コードプルダウンの変更のためのメソッド.
	   * 
	   * @param regionCode 極コード
	   * @return
	   */
	@RequestMapping(value = "/sample5/jobType/{jobType}",
      method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String refreshJobPulldown(@PathVariable("jobType")String jobType) {
	    // job_mappingテーブルから仕事リスト取得
	    return jobMappingService.getPulldownData(jobType);
	}

	@RequestMapping(value = "/sample5", method = RequestMethod.POST)
	public String form(
			@ModelAttribute("formModel") @Validated Person person, 
			BindingResult result,
			Model model) {
		
		if(!result.hasErrors()) {
			personRepository.saveAndFlush(person);
		} else {
			model.addAttribute("msg", "エラーが発生しました");
			return index(person, model);
		}
		
		model.addAttribute("formModel", person);
		Iterable<Person> list = personRepository.findAll();
		model.addAttribute("data", list);
		
		return "/sample3";
		
	}

}
