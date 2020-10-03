package io.github.jmgloria07.gracenote.service;

import io.github.jmgloria07.gracenote.bean.User;
import io.github.jmgloria07.gracenote.bean.web.UserLoginForm;

public interface UserService {
	public User login(UserLoginForm form);
}
