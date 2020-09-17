package io.github.jmgloria07.gracenote.dao;

import java.util.List;

import io.github.jmgloria07.gracenote.object.Grace;

public interface GraceDao {

	public Grace getGrace(long userId, long graceId);
	
	public List<Grace> getGrace(long userId);
	
	public Grace postGrace(Grace grace);
	
	@Deprecated
	public Grace getGrace(String user, long id);
	
	@Deprecated
	public List<Grace> getGrace(String user);
}
