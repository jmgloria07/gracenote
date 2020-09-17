package io.github.jmgloria07.gracenote.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.github.jmgloria07.gracenote.dao.repository.GraceRepository;
import io.github.jmgloria07.gracenote.dao.repository.UserRepository;
import io.github.jmgloria07.gracenote.object.Grace;
import io.github.jmgloria07.gracenote.object.User;
import io.github.jmgloria07.gracenote.object.exception.GraceNoteNotFoundException;

@Repository
@Transactional
public class GraceDaoImpl implements GraceDao {

	@Autowired
	GraceRepository graceRepository;
	
	@Autowired 
	UserRepository userRepository;
	
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
		if (userRepository.existsById(userId)) {
			Grace grace = graceRepository.findById(graceId).orElseThrow(() -> new GraceNoteNotFoundException());
			if (grace.getUser().getId() == userId) {
				return grace;
			}
		}
		throw new GraceNoteNotFoundException();
	}

	@Override
	public List<Grace> getGrace(long userId) {
		Optional<User> user = userRepository.findById(userId);
		
		if (!user.isPresent()) throw new GraceNoteNotFoundException();
		
		return user.get().getGraces();
	}




}
