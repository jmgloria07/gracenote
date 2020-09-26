package io.github.jmgloria07.gracenote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jmgloria07.gracenote.bean.Grace;
import io.github.jmgloria07.gracenote.bean.Opening;
import io.github.jmgloria07.gracenote.bean.User;
import io.github.jmgloria07.gracenote.bean.exception.GraceNoteParameterException;
import io.github.jmgloria07.gracenote.bean.web.GraceForm;
import io.github.jmgloria07.gracenote.dao.GraceDao;

@Service
public class GraceServiceImpl implements GraceService {

	@Autowired
	GraceDao graceDao;
	
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
		Grace graceDaoParam = new Grace();
		graceDaoParam.setText(graceForm.getDisplayText());
		
		Opening openingDaoParam = new Opening();
		openingDaoParam.setId(graceForm.getOpening());
		graceDaoParam.setOpening(openingDaoParam);
		
		User userDaoParam = new User();
		userDaoParam.setId(userId);
		graceDaoParam.setUser(userDaoParam);
		
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
