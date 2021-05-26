package com.ms.dept.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dept.dto.DeportmentDTO;
import com.ms.dept.entity.Deportment;
import com.ms.dept.repo.DeptRepository;

@Service
public class DeportmentService {
	
	@Autowired
	DeptRepository deptRepository;

	public void create(DeportmentDTO deptDTO) {
		Deportment dept=deptDTO.createEntity();
		deptRepository.save(dept);
		
	}

	public void update(DeportmentDTO deptDTO) {
		Deportment update=deptRepository.findById(deptDTO.getDno()).get();		
		update.setLocation(deptDTO.getLocation());
		update.setName(deptDTO.getName());
		deptRepository.save(update);
	}

	public void delete(DeportmentDTO deptDTO) {
		Deportment dept=deptDTO.createEntity();
		deptRepository.delete(dept);
		
	}

	public List<DeportmentDTO> all() {
		
		List<DeportmentDTO> dtos=new ArrayList<DeportmentDTO>();
		for(Deportment dept:deptRepository.findAll()){
			DeportmentDTO dto=new DeportmentDTO(dept.getDno(),dept.getName(),dept.getLocation()); 
			dtos.add(dto);
		}		
		return dtos;
	}

	public DeportmentDTO get(Integer dno) {
		Deportment dept=deptRepository.findById(dno).get();		
		return new DeportmentDTO(dept.getDno(),dept.getName(),dept.getLocation()); 
	}
	
	
	

}
