package com.ms.emp.dto;

import com.ms.emp.entity.Employee;

public class EmployeeDTO {

	private Integer eno;
	private String name;
	private String location;
	private Integer dno;
	
	

	public EmployeeDTO() {
		
	}

	public EmployeeDTO(Integer eno, String name, String location, Integer dno) {
		super();
		this.eno = eno;
		this.name = name;
		this.location = location;
		this.dno = dno;
	}

	public Integer getEno() {
		return eno;
	}

	public void setEno(Integer eno) {
		this.eno = eno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getDno() {
		return dno;
	}

	public void setDno(Integer dno) {
		this.dno = dno;
	}

	public Employee createEntity() {
		Employee emp = new Employee();
		emp.setEno(this.getEno());
		emp.setName(this.getName());
		emp.setLocation(this.getLocation());
		emp.setDno(this.getDno());
		return emp;
	}
}
