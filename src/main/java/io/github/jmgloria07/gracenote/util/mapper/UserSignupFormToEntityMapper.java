package io.github.jmgloria07.gracenote.util.mapper;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import io.github.jmgloria07.gracenote.bean.User;
import io.github.jmgloria07.gracenote.bean.web.UserSignupForm;

@Component
public class UserSignupFormToEntityMapper implements FormToEntityMapper<UserSignupForm, User> {

	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public User mapFormToEntity(UserSignupForm form) {
		User user = new User();
		
		user.setName(form.getUsername());
		user.setPasswordHash(encoder.encode(form.getPassword()));
		user.setDateCreated(LocalDate.now());
		user.setAdmin(false);
		
		return user;
	}

}
