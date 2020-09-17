package io.github.jmgloria07.gracenote.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.github.jmgloria07.gracenote.dao.repository.GraceRepository;
import io.github.jmgloria07.gracenote.dao.repository.OpeningRepository;
import io.github.jmgloria07.gracenote.dao.repository.UserRepository;
import io.github.jmgloria07.gracenote.object.Grace;
import io.github.jmgloria07.gracenote.object.Opening;
import io.github.jmgloria07.gracenote.object.User;
import io.github.jmgloria07.gracenote.object.exception.GraceNoteNotFoundException;
import io.github.jmgloria07.gracenote.object.exception.GraceNoteParameterException;

@Repository
@Transactional
public class GraceDaoImpl implements GraceDao {

	@Autowired
	GraceRepository graceRepository;
	
	@Autowired 
	UserRepository userRepository;
	
	@Autowired 
	OpeningRepository openingRepository;
	
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
	
	@Override
	public Grace getGrace(long userId, long graceId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new GraceNoteNotFoundException());
		
		return user.getGraces().stream()
				.filter(grace -> grace.getId() == graceId)
				.findFirst()
				.orElseThrow(() -> new GraceNoteNotFoundException());
	}

	@Override
	public List<Grace> getGrace(long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new GraceNoteNotFoundException());
		return user.getGraces();
	}

	@Override
	public Grace postGrace(Grace grace) {
		long userId = Optional.ofNullable(grace).map(Grace::getUser).map(User::getId)
				.orElseThrow(() -> new GraceNoteParameterException());
		
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new GraceNoteNotFoundException());
		
		long openingId = Optional.ofNullable(grace).map(Grace::getOpening).map(Opening::getId)
				.orElseThrow(() -> new GraceNoteParameterException());
		
		Opening opening = openingRepository.findById(openingId)
				.orElseThrow(() -> new GraceNoteNotFoundException());
		
		grace.setUser(user);
		grace.setOpening(opening);
		
		return graceRepository.save(grace);
	}




}
