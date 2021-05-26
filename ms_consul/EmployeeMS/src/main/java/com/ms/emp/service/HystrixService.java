package com.ms.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.emp.dto.DeportmentDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HystrixService {
	
	
	/* @Autowired RestTemplate restTemplate; */
	 
	@Autowired
	DeportmentFeign deportmentFeign;
	
   @HystrixCommand(fallbackMethod = "getFallback")
	public DeportmentDTO getDept(Integer dno) {
		//DeportmentDTO dempdto = restTemplate.getForObject(getURL()+dno, DeportmentDTO.class);	
		DeportmentDTO dempdto =deportmentFeign.get(dno);
		return dempdto;
	}
   
   public DeportmentDTO getFallback(Integer dno) {	
	 return new DeportmentDTO();
   }  
	
	private String getURL(){		
			String url="http://DeportmentMS/dept/";
			return url;
		}

}
