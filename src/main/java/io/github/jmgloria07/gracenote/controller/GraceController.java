package io.github.jmgloria07.gracenote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.github.jmgloria07.gracenote.object.Grace;
import io.github.jmgloria07.gracenote.service.GraceService;

@RestController
public class GraceController {
	 
	@Autowired
	GraceService graceService;
	
	@GetMapping(path = "/{user}/grace/{id}") 
	public Grace getGrace(@PathVariable String user, @PathVariable String id) {
		return graceService.getGrace(user, id);
	}
	
	@GetMapping(path = "/{user}/grace/") 
	public List<Grace> getGrace(@PathVariable String user) {
		return graceService.getGrace(user);
	}
}