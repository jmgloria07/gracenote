package io.github.jmgloria07.gracenote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jmgloria07.gracenote.bean.Grace;
import io.github.jmgloria07.gracenote.bean.exception.GraceNoteParameterException;
import io.github.jmgloria07.gracenote.bean.web.GraceForm;
import io.github.jmgloria07.gracenote.dao.GraceDao;
import io.github.jmgloria07.gracenote.util.mapper.GraceFormToEntityMapper;

@Service
public class GraceServiceImpl implements GraceService {

	@Autowired
	GraceDao graceDao;
	
	@Autowired
	GraceFormToEntityMapper graceMapper;
	
	@Override
	public Grace getGrace(long userId, long graceId) {
		return graceDao.getGrace(userId, graceId);
	}

	@Override
	public List<Grace> getGrace(long userId) {
		return graceDao.getGrace(userId);
	}

	@Override
	public Grace postGrace(long userId, GraceForm graceForm) {		
		Grace graceDaoParam = graceMapper
				.withUserId(userId)
				.mapFormToEntity(graceForm);		
		return graceDao.postGrace(graceDaoParam);
	}

	@Deprecated
	@Override
	public Grace getGrace(String user, String id) {
		try {
			return graceDao.getGrace(user, Long.parseLong(id));
		} catch (NumberFormatException e) {
			throw new GraceNoteParameterException(e);
		}
	}

}
