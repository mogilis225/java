package com.ms.emp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.emp.dto.EmployeeDTO;
import com.ms.emp.entity.Employee;
import com.ms.emp.repo.EmpRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmpRepository empRepository;

	public void create(EmployeeDTO emp) {
		empRepository.save(emp.createEntity());
		
	}

	public void update(EmployeeDTO dto) {
		Employee update=empRepository.findById(dto.getEno()).get();
		update.setLocation(dto.getLocation());
		update.setName(dto.getName());
		update.setDno(dto.getDno());
		empRepository.save(update);
	}

	public void delete(EmployeeDTO emp) {
		empRepository.delete(emp.createEntity());
		
	}

	public List<EmployeeDTO> all(){
		List<EmployeeDTO>  dtos=new ArrayList<EmployeeDTO>();
		for(Employee emp:empRepository.findAll()){
			dtos.add(new EmployeeDTO(emp.getEno(), emp.getName(), emp.getLocation(), emp.getDno()));
		}
		return dtos;
		
	}

	public EmployeeDTO get(Integer eno) {
		Employee emp=empRepository.findById(eno).get();
		return new EmployeeDTO(emp.getEno(), emp.getName(), emp.getLocation(), emp.getDno());
	}	

}
