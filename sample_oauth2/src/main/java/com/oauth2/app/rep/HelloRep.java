package com.oauth2.app.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oauth2.app.entity.HelloEntity;


@Repository
public interface HelloRep extends JpaRepository<HelloEntity, Integer>{


}

