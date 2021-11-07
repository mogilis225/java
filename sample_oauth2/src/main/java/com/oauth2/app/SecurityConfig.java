package com.oauth2.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        //HTTP Basic authentication
        .httpBasic()
        .and()
        .authorizeRequests()    
        
        .antMatchers(HttpMethod.GET, "/api/v2/hello/**").hasRole("USER")        
        .antMatchers(HttpMethod.POST, "/api/v2/hello/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.PUT, "/api/v2/hello/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.DELETE, "/api/v2/hello/**").hasRole("ADMIN")
    
        .and()
        .csrf().disable()
        .formLogin().disable();
	}
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		
	return new BCryptPasswordEncoder();	
	}

}
