package com.example.demo.data;

import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "person")
public class Person {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(length = 50, nullable =false)
	@NotEmpty
	private String name;
	
	@Min(value=0)
	@Max(value=150)
	private Integer age;
	
	private String jobType;
	
	private String jobTypeInput;
	
	private LinkedHashMap<String, String> jobTypeMap;
	
	private String job;
	
	private String jobJson;
	
	private String jobInput;
	
	private LinkedHashMap<String, String> jobMap;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getJobType() {
		return jobType;
	}
	
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	
	public String getJobTypeInput() {
		return jobTypeInput;
	}

	public void setJobTypeInput(String jobTypeInput) {
		this.jobTypeInput = jobTypeInput;
	}

	public LinkedHashMap<String, String> getJobTypeMap() {
		return jobTypeMap;
	}

	public void setJobTypeMap(LinkedHashMap<String, String> jobTypeMap) {
		this.jobTypeMap = jobTypeMap;
	}

	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}

	public String getJobJson() {
		return jobJson;
	}

	public void setJobJson(String jobJson) {
		this.jobJson = jobJson;
	}
	
	public String getJobInput() {
		return jobInput;
	}

	public void setJobInput(String jobInput) {
		this.jobInput = jobInput;
	}

	public LinkedHashMap<String, String> getJobMap() {
		return jobMap;
	}

	public void setJobMap(LinkedHashMap<String, String> jobMap) {
		this.jobMap = jobMap;
	}
	
}
