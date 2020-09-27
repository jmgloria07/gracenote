package io.github.jmgloria07.gracenote.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.github.jmgloria07.gracenote.bean.Grace;
import io.github.jmgloria07.gracenote.bean.Opening;
import io.github.jmgloria07.gracenote.bean.User;
import io.github.jmgloria07.gracenote.bean.exception.GraceNoteNotFoundException;
import io.github.jmgloria07.gracenote.bean.exception.GraceNoteParameterException;
import io.github.jmgloria07.gracenote.dao.repository.GraceRepository;
import io.github.jmgloria07.gracenote.dao.repository.OpeningRepository;
import io.github.jmgloria07.gracenote.dao.repository.UserRepository;

@Repository
@Transactional
public class DatabaseGraceDao implements GraceDao {

	@Autowired
	GraceRepository graceRepository;
	
	@Autowired 
	UserRepository userRepository;
	
	@Autowired 
	OpeningRepository openingRepository;
	
	@Override
	public Grace getGrace(long userId, long graceId) {
		User user = userRepository.findById(userId)
				.orElseThrow(GraceNoteNotFoundException::new);
		
		return user.getGraces().stream()
				.filter(grace -> grace.getId() == graceId)
				.findFirst()
				.orElseThrow(GraceNoteNotFoundException::new);
	}

	@Override
	public List<Grace> getGrace(long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new GraceNoteNotFoundException());
		return user.getGraces();
	}

	@Override
	public Grace postGrace(Grace grace) {
		long userId = Optional.ofNullable(grace).map(Grace::getUser).map(User::getId)
				.orElseThrow(GraceNoteParameterException::new);
		
		User user = userRepository.findById(userId)
				.orElseThrow(GraceNoteNotFoundException::new);
		
		long openingId = Optional.ofNullable(grace).map(Grace::getOpening).map(Opening::getId)
				.orElseThrow(GraceNoteParameterException::new);
		
		Opening opening = openingRepository.findById(openingId)
				.orElseThrow(GraceNoteNotFoundException::new);
		
		grace.setUser(user);
		grace.setOpening(opening);
		grace.setDateCreated(LocalDate.now());//use date today
		
		return graceRepository.save(grace);
	}
	
	@Deprecated
	@Override
	public Grace getGrace(String user, long id) {
		return graceRepository.findByUserNameAndId(user, id).orElseThrow(() -> new GraceNoteNotFoundException());
	}

	@Deprecated
	@Override
	public List<Grace> getGrace(String user) {
		return graceRepository.findAllByUserName(user);
	}
}
