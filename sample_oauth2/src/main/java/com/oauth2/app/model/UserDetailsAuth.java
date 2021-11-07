package com.oauth2.app.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.oauth2.app.entity.UserAuth;

public class UserDetailsAuth implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private List<GrantedAuthority> roles;
	private boolean active;

	UserDetailsAuth() {

	}

  public UserDetailsAuth(UserAuth loginUser) {
		this.username = loginUser.getUsername();
		this.password = loginUser.getPassword();
		
		String rl[] = loginUser.getRoles().split(",");
		this.roles = Stream.of(rl).map(SimpleGrantedAuthority::new).collect(Collectors.toList());		
		this.active = loginUser.isActive();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return roles;
	}

	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public String getUsername() {

		return username;
	}

	@Override
	public boolean isAccountNonExpired() {

		return active;
	}

	@Override
	public boolean isAccountNonLocked() {

		return active;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return active;
	}

	@Override
	public boolean isEnabled() {

		return active;
	}

}
