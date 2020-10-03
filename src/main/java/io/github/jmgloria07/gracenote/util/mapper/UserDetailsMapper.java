package io.github.jmgloria07.gracenote.util.mapper;

import org.springframework.security.core.userdetails.UserDetails;

import io.github.jmgloria07.gracenote.bean.User;

public interface UserDetailsMapper {
	
	public UserDetails toUserDetails(User user);
}
