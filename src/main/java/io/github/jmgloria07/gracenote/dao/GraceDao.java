package io.github.jmgloria07.gracenote.dao;

import java.util.List;

import io.github.jmgloria07.gracenote.object.Grace;

public interface GraceDao {

	public Grace getGrace(String user, long id);
	
	public List<Grace> getGrace(String user);
}
