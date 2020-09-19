package io.github.jmgloria07.gracenote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.jmgloria07.gracenote.object.Grace;
import io.github.jmgloria07.gracenote.object.web.GraceForm;
import io.github.jmgloria07.gracenote.service.GraceService;

@CrossOrigin
@RestController
public class GraceResource {
	 
	@Autowired
	GraceService graceService;
	
	@GetMapping(path = "/{user}/graces/{id}") 
	public Grace getGrace(@PathVariable long user, @PathVariable long id) {
		return graceService.getGrace(user, id);
	}
	
	@GetMapping(path = "/{user}/graces") 
	public List<Grace> getGrace(@PathVariable long user) {
		return graceService.getGrace(user);
	}
	
	@PostMapping(path = "/{user}/graces")
	public Grace postGrace(@PathVariable long user, 
			@RequestBody GraceForm graceForm) {
		return graceService.postGrace(user, graceForm);
	}
}