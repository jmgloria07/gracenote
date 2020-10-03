package io.github.jmgloria07.gracenote.util.mapper;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Component
public class DefaultUserDetailsMapper implements UserDetailsMapper {

	@Override
	public UserDetails toUserDetails(io.github.jmgloria07.gracenote.bean.User user) {
		UserDetails result = new User(user.getName(), "$2y$10$kK69Ca6zeKMpmmZ4IkLtGOqb3TzVeY8GSsGjuIaMDzzmfQUIIahDW",
				Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
		return result;
	}

}
