package com.ms.emp.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ms.emp.dto.DeportmentDTO;

@FeignClient("DeportmentMS/dept")
public interface DeportmentFeign {
	
	
	@RequestMapping(value = "/{dno}", method = RequestMethod.GET)
	public DeportmentDTO get(@PathVariable Integer dno);
	
	@GetMapping("/all")
	public List<DeportmentDTO> all();

}
