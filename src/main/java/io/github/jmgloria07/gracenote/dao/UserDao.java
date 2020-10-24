package io.github.jmgloria07.gracenote.dao;

import java.util.List;

import io.github.jmgloria07.gracenote.bean.User;

public interface UserDao {
	public User login(String username, String password);
	public User signup(User user);
	public List<User> findAllUsers();
	public User findUserByName(String username);
	public User getUser(long user);
}
