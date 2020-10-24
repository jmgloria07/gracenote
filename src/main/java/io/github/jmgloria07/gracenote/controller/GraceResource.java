package io.github.jmgloria07.gracenote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.jmgloria07.gracenote.bean.Grace;
import io.github.jmgloria07.gracenote.bean.web.GraceForm;
import io.github.jmgloria07.gracenote.service.GraceService;
import io.github.jmgloria07.gracenote.service.UserService;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class GraceResource {
	 
	@Autowired
	GraceService graceService;
	
	@Autowired
	UserService userService;
	
	@GetMapping(path = "/users/{user}/graces/{id}")
	public Grace retrieveGrace(@PathVariable long user, @PathVariable long id) {
		userService.getUser(user);
		return graceService.getGrace(user, id);
	}
	
	@GetMapping(path = "/users/{user}/graces") 
	public List<Grace> retrieveGraces(@PathVariable long user) {
		userService.getUser(user);
		return graceService.getGrace(user);
	}
	
	@PostMapping(path = "/users/{user}/graces")
	public Grace createGrace(@PathVariable long user, 
			@RequestBody GraceForm graceForm) {
		userService.getUser(user);
		return graceService.postGrace(user, graceForm);
	}
}