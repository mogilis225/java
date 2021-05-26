package com.ms.emp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ms.emp.dto.DeportmentDTO;
import com.ms.emp.dto.EmpDeptDTO;
import com.ms.emp.dto.EmployeeDTO;
import com.ms.emp.service.EmployeeService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    
	@Autowired
	EmployeeService eService;
	
	@Autowired
	RestTemplate restTemplate;
	
	/*@Autowired
	private EurekaClient eurekaClient;*/
	   
	@PostMapping("/add")
	public void create(@RequestBody EmployeeDTO emp){
		eService.create(emp);
	}
    
	@PutMapping("/update")
	public void update(@RequestBody EmployeeDTO emp){
		eService.update(emp);
	}
	@DeleteMapping("/delete")
	public void delete(@RequestBody EmployeeDTO emp){
		eService.delete(emp);
	}
	@GetMapping("/all")
	public List<EmpDeptDTO> all(){	
		System.out.println("@@@@@@@@@@@@ EmployeeMS @@@@@@@@@ -all");
		List<EmpDeptDTO> vos=new ArrayList<EmpDeptDTO>();
		for(EmployeeDTO empdto:eService.all()){
			EmpDeptDTO vo=new EmpDeptDTO();
			vo.setEmployee(empdto);
			DeportmentDTO dempdto = restTemplate.getForObject(getURL()+empdto.getDno(), DeportmentDTO.class);
			vo.setDeportment(dempdto);
			vos.add(vo);
		}
		return vos;
	}
	@GetMapping("/{eno}")
	public EmpDeptDTO get(@PathVariable Integer eno){
		
		System.out.println("@@@@@@@@@@@@ EmployeeMS @@@@@@@@@ -eno");
		EmpDeptDTO vo=new EmpDeptDTO();
		EmployeeDTO empdto=eService.get(eno);
		vo.setEmployee(empdto); 
		DeportmentDTO dempdto = restTemplate.getForObject(getURL()+empdto.getDno(), DeportmentDTO.class);
		vo.setDeportment(dempdto);
		return vo;
	}
	private String getURL(){
	/*	 Application application =
			      eurekaClient.getApplication("DeportmentMS");
		 InstanceInfo instanceInfo = application.getInstances().get(0);
		 String url=instanceInfo.getHomePageUrl()+"/dept/";*/
		String url="http://DeportmentMS/dept/";
		return url;
	}
}
