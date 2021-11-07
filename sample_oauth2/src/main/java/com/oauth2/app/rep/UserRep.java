package com.oauth2.app.rep;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oauth2.app.entity.UserAuth;

@Repository
public interface UserRep extends  JpaRepository<UserAuth,Integer>
{
	
	Optional<UserAuth> findByUsername(String username);

}
