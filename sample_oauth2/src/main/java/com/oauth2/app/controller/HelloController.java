package com.oauth2.app.controller;

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

import com.oauth2.app.model.Hello;
import com.oauth2.app.service.HWService;


@RestController
@RequestMapping("/api/v2/hello")
public class HelloController {
	
	@Autowired
    private HWService hWService;
	
	@GetMapping("/{id}")
	public Hello getById(@PathVariable Integer id) {	
		System.out.println("Start****getById*************");
		Hello hello=hWService.findById(id); 
		System.out.println("End****getById*************");
	return hello;
	}
	@GetMapping("/all")
	public List<Hello> getAll() {
		System.out.println("Start****getAll*************");
		List<Hello> hellos=hWService.findAll(); 
		System.out.println("End****getAll*************");
	return hellos;
	}
	@PostMapping("/add")
	public String create(@RequestBody Hello hello) {
		System.out.println("Start****post*************");		
		hWService.save(hello);
		System.out.println("End*****post************");
		return "Saved Successfully";
	}
	@PutMapping("/update")
	public String update(@RequestBody Hello hello) {
		hWService.update(hello);		
	return "Updated Successfully";
	}
	@DeleteMapping("/delete")
	public String deleteBYId(@RequestBody Hello hello) {
		
		hWService.deleteBYId(hello.getId());
		
	return "Deleted Successfully";
	}


}
