package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.data.JobMapping;

@Repository
public interface JobMappingRepository extends JpaRepository<JobMapping, Integer> {
	
  @Query(value = "SELECT DISTINCT job_type FROM job_mapping", nativeQuery = true)
  	public List<String> findDistinctJobType();
	
	public List<JobMapping> findByJobType(String jobType);
	
}
