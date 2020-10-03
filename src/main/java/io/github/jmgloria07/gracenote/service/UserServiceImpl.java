package io.github.jmgloria07.gracenote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jmgloria07.gracenote.bean.User;
import io.github.jmgloria07.gracenote.bean.web.UserLoginForm;
import io.github.jmgloria07.gracenote.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User login(UserLoginForm form) {
		return userDao.login(form.getUsername(), form.getPassword());
	}

}
