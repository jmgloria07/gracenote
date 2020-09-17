package io.github.jmgloria07.gracenote.dao;

import java.util.List;

import io.github.jmgloria07.gracenote.object.Opening;

public interface OpeningDao {
	public List<Opening> getOpenings();
	public Opening getOpening(long id);
}
