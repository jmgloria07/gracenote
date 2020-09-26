package io.github.jmgloria07.gracenote.service;

import java.util.List;

import io.github.jmgloria07.gracenote.bean.Opening;

public interface OpeningService {
	public List<Opening> getOpenings();
	public Opening getOpening(long id);
}
