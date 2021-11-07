package com.oauth2.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oauth2.app.entity.UserAuth;
import com.oauth2.app.model.UserDetailsAuth;
import com.oauth2.app.rep.UserRep;
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
	
    @Autowired
	private UserRep userRep;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserAuth> loginUser=userRep.findByUsername(username);
		System.out.println("@@@@@@@@@@"+loginUser);
		return new UserDetailsAuth(loginUser.get());
	}

}
