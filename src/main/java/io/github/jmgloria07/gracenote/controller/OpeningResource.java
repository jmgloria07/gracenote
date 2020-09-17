package io.github.jmgloria07.gracenote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.jmgloria07.gracenote.object.Opening;
import io.github.jmgloria07.gracenote.object.exception.GraceNoteMethodNotSupportedException;
import io.github.jmgloria07.gracenote.service.OpeningService;

@RestController
public class OpeningResource {

	@Autowired
	OpeningService openingService;
	
	@GetMapping("/openings/")
	public List<Opening> getOpening() {
		return openingService.getOpenings();
	}
	
	@GetMapping("/openings/{id}")
	public Opening getOpening(@PathVariable long id) {
		return openingService.getOpening(id);
	}
	
	@PostMapping("/openings/")
	public Opening postOpening() {
		throw new GraceNoteMethodNotSupportedException();
	}
}
