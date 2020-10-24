package io.github.jmgloria07.gracenote.service;

import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;

import io.github.jmgloria07.gracenote.bean.User;
import io.github.jmgloria07.gracenote.bean.web.UserLoginForm;
import io.github.jmgloria07.gracenote.bean.web.UserSignupForm;

public interface UserService{
	
	public User login(UserLoginForm form);
	public User createUser(UserSignupForm form);
	public List<User> getAllUsers();
	
	@PostAuthorize("returnObject.name == authentication.name")
	public User getUser(long user);
}
