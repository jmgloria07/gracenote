package io.github.jmgloria07.gracenote.service;

import java.util.List;

import io.github.jmgloria07.gracenote.object.Grace;

public interface GraceService {
	@Deprecated
	public Grace getGrace(String user, String id);
	
	public Grace getGrace(long userId, long graceId);

	public List<Grace> getGrace(long user);
}
