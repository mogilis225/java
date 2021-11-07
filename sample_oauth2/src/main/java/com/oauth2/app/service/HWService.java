package com.oauth2.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oauth2.app.entity.HelloEntity;
import com.oauth2.app.model.Hello;
import com.oauth2.app.rep.HelloRep;

@Service
public class HWService {

	@Autowired
	private HelloRep helloRep;

	public Hello findById(Integer id) {
		
		HelloEntity he=helloRep.findById(id).get();
		return new Hello(he.getId(),he.getMessage());
	}

	public List<Hello> findAll() {

		return helloRep.findAll().stream().map(e->new Hello(e.getId(),e.getMessage())).collect(Collectors.toList());
	}

	public void save(Hello hello) {
		HelloEntity he=new HelloEntity(hello.getId(), hello.getMessage());
		helloRep.save(he);

	}

	public void update(Hello hello) {
		HelloEntity he=helloRep.findById(hello.getId()).get();		
		he.setMessage(hello.getMessage());
		helloRep.save(he);

	}

	public void deleteBYId(Integer id) {
		helloRep.deleteById(id);
	}

}
