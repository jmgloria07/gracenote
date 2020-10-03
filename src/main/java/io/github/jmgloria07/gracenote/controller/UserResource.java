package io.github.jmgloria07.gracenote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.jmgloria07.gracenote.bean.User;
import io.github.jmgloria07.gracenote.bean.exception.GraceNoteMethodNotSupportedException;
import io.github.jmgloria07.gracenote.bean.web.UserLoginForm;
import io.github.jmgloria07.gracenote.service.UserService;

import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
public class UserResource {

	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public User login(@RequestBody UserLoginForm user) {
		return userService.login(user);
	}
	
	@GetMapping("/users")
	public void getUsers() {
		throw new GraceNoteMethodNotSupportedException();
	}
	
	@PostMapping("/users")
	public void signup() {
		
	}
}
