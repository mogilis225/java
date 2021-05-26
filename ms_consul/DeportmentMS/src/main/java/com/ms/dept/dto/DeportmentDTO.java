package com.ms.dept.dto;

import java.io.Serializable;

import com.ms.dept.entity.Deportment;

public class DeportmentDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private Integer dno;
	private String name;
	private String location;
	
	public DeportmentDTO(){
		
	}
	
	public DeportmentDTO(Integer dno, String name, String location) {
		super();
		this.dno = dno;
		this.name = name;
		this.location = location;
	}

	public Integer getDno() {
		return dno;
	}
	public void setDno(Integer dno) {
		this.dno = dno;
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
	
	public Deportment createEntity(){
		Deportment dept=new Deportment();
		dept.setDno(this.getDno());
		dept.setLocation(this.getLocation());
		dept.setName(this.getName());
	return dept;	
	}
	
	
}
