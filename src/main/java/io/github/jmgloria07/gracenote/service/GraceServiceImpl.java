package io.github.jmgloria07.gracenote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.jmgloria07.gracenote.dao.GraceDao;
import io.github.jmgloria07.gracenote.object.Grace;
import io.github.jmgloria07.gracenote.object.exception.GraceNoteParameterException;

@Component
public class GraceServiceImpl implements GraceService {

	@Autowired
	GraceDao graceDao;
	
	@Deprecated
	@Override
	public Grace getGrace(String user, String id) {
		try {
			return graceDao.getGrace(user, Long.parseLong(id));
		} catch (NumberFormatException e) {
			throw new GraceNoteParameterException(e);
		}
		
	}
	
	@Override
	public Grace getGrace(long userId, long graceId) {
		return graceDao.getGrace(userId, graceId);
	}

	@Override
	public List<Grace> getGrace(long user) {
		return graceDao.getGrace(user);
	}

	

}
