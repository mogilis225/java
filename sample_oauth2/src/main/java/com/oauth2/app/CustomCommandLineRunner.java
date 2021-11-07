package com.oauth2.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.oauth2.app.entity.UserAuth;
import com.oauth2.app.model.Hello;
import com.oauth2.app.rep.UserRep;
import com.oauth2.app.service.HWService;

//@Component
public class CustomCommandLineRunner implements CommandLineRunner{

	@Autowired
	private UserRep userRep;
	
	@Autowired
	PasswordEncoder  pwed;
	
	@Autowired
    private HWService hWService;
	
	@Override
	public void run(String... args) throws Exception {
		
		UserAuth userAuth1=new UserAuth();
		userAuth1.setActive(true);
		userAuth1.setPassword(pwed.encode("pwd1"));
		userAuth1.setRoles("ROLE_USER");
		userAuth1.setUsername("user1");
		
		userRep.save(userAuth1);
		
		UserAuth userAuth2=new UserAuth();
		userAuth2.setActive(true);
		userAuth2.setPassword(pwed.encode("pwd2"));
		userAuth2.setRoles("ROLE_USER,ROLE_ADMIN");
		userAuth2.setUsername("user2");
		
		userRep.save(userAuth2);
		
		UserAuth userAuth3=new UserAuth();
		userAuth3.setActive(true);
		userAuth3.setPassword(pwed.encode("pwd3"));
		userAuth3.setRoles("ROLE_ADMIN");
		userAuth3.setUsername("user3");
		
		userRep.save(userAuth3);
		
		Hello hello=new Hello();
		hello.setMessage("Hi");
		hWService.save(hello);
		
	}

}
