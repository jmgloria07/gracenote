package io.github.jmgloria07.gracenote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.jmgloria07.gracenote.bean.User;
import io.github.jmgloria07.gracenote.bean.web.UserLoginForm;
import io.github.jmgloria07.gracenote.bean.web.UserSignupForm;
import io.github.jmgloria07.gracenote.service.UserService;

import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
public class UserResource {

	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	@PreAuthorize("#userForm.username == authentication.name")
	@PostAuthorize("returnObject.name == authentication.name")
	public User login(@RequestBody UserLoginForm userForm) {
		return userService.login(userForm);
	}
	
	@GetMapping("/users")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{user}")
	@PreAuthorize("isAuthenticated()")
	public User getUser(@PathVariable long user) {
		return userService.getUser(user);
	}
	
	@PostMapping("/users")
	@PreAuthorize("permitAll")
	public User signup(@RequestBody UserSignupForm userForm) {
		return userService.createUser(userForm);
	}
}
