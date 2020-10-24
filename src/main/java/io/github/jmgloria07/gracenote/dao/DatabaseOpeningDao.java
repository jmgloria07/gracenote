package io.github.jmgloria07.gracenote.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.github.jmgloria07.gracenote.bean.Opening;
import io.github.jmgloria07.gracenote.bean.exception.GraceNoteNotFoundException;
import io.github.jmgloria07.gracenote.dao.repository.OpeningRepository;

@Transactional
@Repository
public class DatabaseOpeningDao implements OpeningDao {

	@Autowired
	OpeningRepository openingRepository;
	
	@Override
	public List<Opening> getOpenings() {
		return openingRepository.findAll();
	}

	@Override
	public Opening getOpening(long id) {
		return openingRepository
				.findById(id)
				.orElseThrow(GraceNoteNotFoundException::new);
	}

}
