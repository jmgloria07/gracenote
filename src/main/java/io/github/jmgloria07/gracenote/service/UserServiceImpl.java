package io.github.jmgloria07.gracenote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import io.github.jmgloria07.gracenote.bean.User;
import io.github.jmgloria07.gracenote.bean.web.UserLoginForm;
import io.github.jmgloria07.gracenote.bean.web.UserSignupForm;
import io.github.jmgloria07.gracenote.dao.UserDao;
import io.github.jmgloria07.gracenote.util.mapper.FormToEntityMapper;
import io.github.jmgloria07.gracenote.util.mapper.UserDetailsMapper;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	FormToEntityMapper<UserSignupForm, User> userSignupFormToEntityMapper;
	
	@Autowired
	UserDetailsMapper userDetailsMapper;
	
	@Override
	public User login(UserLoginForm form) {
		return userDao.login(form.getUsername(), form.getPassword());
	}

	@Override
	public User createUser(UserSignupForm form) {
		User user = userSignupFormToEntityMapper.mapFormToEntity(form);
		return userDao.signup(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.findAllUsers();
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = userDao.findUserByName(username);
		return userDetailsMapper.toUserDetails(user);
	}

	@Override
	public User getUser(long user) {
		return userDao.getUser(user);
	}

}
