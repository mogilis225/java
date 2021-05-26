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

import com.ms.emp.dto.DeportmentDTO;
import com.ms.emp.dto.EmpDeptDTO;
import com.ms.emp.dto.EmployeeDTO;
import com.ms.emp.service.EmployeeService;
import com.ms.emp.service.HystrixService;


@RestController
@RequestMapping("/emp")
public class EmployeeController {
    
	@Autowired
	EmployeeService eService;
	
	
	@Autowired
	HystrixService hystrixService;
	
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
			DeportmentDTO dempdto =hystrixService.getDept(empdto.getDno());			
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
		DeportmentDTO dempdto =hystrixService.getDept(empdto.getDno());
		vo.setDeportment(dempdto);
		return vo;
	}
	
}
