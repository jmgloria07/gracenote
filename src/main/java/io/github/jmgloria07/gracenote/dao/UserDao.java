package io.github.jmgloria07.gracenote.dao;

import io.github.jmgloria07.gracenote.bean.User;

public interface UserDao {
	public User login(String username, String password);
}
