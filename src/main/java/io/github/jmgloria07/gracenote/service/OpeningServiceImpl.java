package io.github.jmgloria07.gracenote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jmgloria07.gracenote.dao.OpeningDao;
import io.github.jmgloria07.gracenote.object.Opening;

@Service
public class OpeningServiceImpl implements OpeningService {

	@Autowired
	OpeningDao openingDao;
	
	@Override
	public List<Opening> getOpenings() {
		return openingDao.getOpenings();
	}

	@Override
	public Opening getOpening(long id) {
		return openingDao.getOpening(id);
	}

}
