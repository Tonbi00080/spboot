package com.example.demo.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.data.JobMapping;
import com.example.demo.repository.JobMappingRepository;

@Service
@Transactional
public class JobMappingService {
	
	@Autowired
	private JobMappingRepository jobMappingRepository;
	
	/**
	 * jobTypeのjob取得
	 * @param jobType
	 * @return List<JobMapping>
	 */
	public List<JobMapping> findJobs(String jobType){
		return jobMappingRepository.findByJobType(jobType);
	}
	
	
	/**
	 * jobのプルダウンデータ取得
	 * @param jobType
	 * @return String
	 */
	public String getPulldownData(String jobType) {
	
		StringBuilder sb = new StringBuilder();
	    sb.append("[{\"label\":\"\", \"value\":\"\"},");
	    
	    List<JobMapping> jobList = findJobs(jobType);
	    
	    for (JobMapping jobMapping: jobList) {
	        sb.append("{\"label\":\"");
	        sb.append(jobMapping.getJob());
	        sb.append("\", \"value\":\"");
	        sb.append(jobMapping.getJob());
	        sb.append("\"},");
	    }
	    
	    // 末尾の","を削除し、"{}"の形式にする
	    sb.deleteCharAt(sb.lastIndexOf(","));
	    sb.append("]");
	    return sb.toString();
	}
}
