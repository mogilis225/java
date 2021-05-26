package com.ms.dept.controller;

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

import com.ms.dept.dto.DeportmentDTO;
import com.ms.dept.service.DeportmentService;

@RestController
@RequestMapping("/dept")
public class DeportmentController {
	
	@Autowired
	DeportmentService dService;
	
	@PostMapping("/add")
	public void create(@RequestBody DeportmentDTO dept){
		dService.create(dept);
	}
    
	@PutMapping("/update")
	public void update(@RequestBody DeportmentDTO dept){
		dService.update(dept);
	}
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeportmentDTO dept){
		dService.delete(dept);
	}
	@GetMapping("/all")
	public List<DeportmentDTO> all(){
		System.out.println("@@@@@@@@@@@ DEPTMS @@@@@@@-all");
		return dService.all();
	}
	@GetMapping("/{dno}")
	public DeportmentDTO get(@PathVariable Integer dno){
		System.out.println("@@@@@@@@@@@ DEPTMS @@@@@@@-dno");
		return dService.get(dno);
	}
	

}
