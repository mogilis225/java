package com.ms.dept.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.dept.entity.Deportment;

public interface DeptRepository extends JpaRepository<Deportment, Integer> {

}
