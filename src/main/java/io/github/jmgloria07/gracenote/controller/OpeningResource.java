package io.github.jmgloria07.gracenote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.jmgloria07.gracenote.bean.Opening;
import io.github.jmgloria07.gracenote.bean.exception.GraceNoteMethodNotSupportedException;
import io.github.jmgloria07.gracenote.service.OpeningService;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class OpeningResource {

	@Autowired
	OpeningService openingService;
	
	@GetMapping("/openings")
	public List<Opening> retrieveAllOpenings() {
		return openingService.getOpenings();
	}
	
	@GetMapping("/openings/{id}")
	public Opening retrieveOpening(@PathVariable long id) {
		return openingService.getOpening(id);
	}
	
	@PostMapping("/openings")
	public Opening createOpening() {
		throw new GraceNoteMethodNotSupportedException();
	}
}
