package com.ms.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.emp.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
