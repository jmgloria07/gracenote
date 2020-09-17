package io.github.jmgloria07.gracenote.service;

import java.util.List;

import io.github.jmgloria07.gracenote.object.Grace;
import io.github.jmgloria07.gracenote.object.web.GraceForm;

public interface GraceService {
	
	public Grace getGrace(long userId, long graceId);

	public List<Grace> getGrace(long userId);
	
	public Grace postGrace(long userId, GraceForm grace);
	
	@Deprecated
	public Grace getGrace(String user, String id);
}
