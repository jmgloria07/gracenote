package io.github.jmgloria07.gracenote.service;

import java.util.List;

import io.github.jmgloria07.gracenote.object.Grace;

public interface GraceService {
	public Grace getGrace(String user, String id);

	public List<Grace> getGrace(String user);
}
