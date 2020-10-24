package io.github.jmgloria07.gracenote.util.mapper;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.github.jmgloria07.gracenote.util.GracenoteConstants;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Component
public class DefaultUserDetailsMapper implements UserDetailsMapper {

	private static final int MAX_ROLES_COUNT = 2;
	
	@Override
	public UserDetails toUserDetails(io.github.jmgloria07.gracenote.bean.User user) {		
		
		UserDetails result = new User(
				user.getName(), 
				user.getPasswordHash(),
				buildGrantedAuthorities(user.isAdmin()));
		
		return result;
	}
	
	private List<SimpleGrantedAuthority> buildGrantedAuthorities(boolean isAdmin) {
		
		List<SimpleGrantedAuthority> result = new ArrayList<>(MAX_ROLES_COUNT);
		result.add(new SimpleGrantedAuthority(GracenoteConstants.ROLE_USER));
		
		if (isAdmin) 
			result.add(new SimpleGrantedAuthority(GracenoteConstants.ROLE_ADMIN));
		
		return result;
	}

}
