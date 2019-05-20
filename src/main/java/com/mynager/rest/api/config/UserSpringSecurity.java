package com.mynager.rest.api.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserSpringSecurity implements UserDetails {

	private static final long serialVersionUID = 1L;

	private long id;
	private String email;
	private String passw;
	private Collection<? extends GrantedAuthority> authorities;

	// constructor
	public UserSpringSecurity() {
	}

	public UserSpringSecurity(long id, String email, String passw, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.email = email;
		this.passw = passw;
		this.authorities = authorities;
	}

	public long getId() {
		return id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return passw;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public boolean hasRole(String role) {
		return getAuthorities().contains(new SimpleGrantedAuthority(role));
	}
}
