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
	public String create(@RequestBody DeportmentDTO dept){
		dService.create(dept);
	return "Added successfully";	
	}
    
	@PutMapping("/update")
	public String update(@RequestBody DeportmentDTO dept){
		dService.update(dept);
		return "Updated successfully";
	}
	@DeleteMapping("/delete")
	public String delete(@RequestBody DeportmentDTO dept){
		dService.delete(dept);
		return "Deleted successfully";
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
