package io.github.jmgloria07.gracenote.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import io.github.jmgloria07.gracenote.bean.User;
import io.github.jmgloria07.gracenote.bean.exception.GraceNoteIncorrectPasswordException;
import io.github.jmgloria07.gracenote.bean.exception.GraceNoteUserAlreadyExistsException;
import io.github.jmgloria07.gracenote.bean.exception.GraceNoteUsernameNotAuthorizedException;
import io.github.jmgloria07.gracenote.dao.repository.UserRepository;
import io.github.jmgloria07.gracenote.util.mapper.UserDetailsMapper;

@Transactional
@Repository
public class DatabaseUserDao implements UserDao {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDetailsMapper userDetailsMapper;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public User findUserByName(String username) {
		return userRepository
			.findUserByName(username)
			.orElseThrow(GraceNoteUsernameNotAuthorizedException::new);		
		
	}

	@Override
	public User login(String username, String password) {
		User user = userRepository
			.findUserByName(username)
			.orElseThrow(GraceNoteUsernameNotAuthorizedException::new);
		
		if (!encoder.matches(password, user.getPasswordHash())) 
			throw new GraceNoteIncorrectPasswordException();
		
		return user;
	}

	@Override
	public User signup(User user) {
		Optional<User> foundUser = userRepository.findUserByName(user.getName());
		if (foundUser.isPresent()) throw new GraceNoteUserAlreadyExistsException();
		return userRepository.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(long user) {
		return userRepository.getOne(user);
	}

}
