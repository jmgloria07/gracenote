package io.github.jmgloria07.gracenote.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import io.github.jmgloria07.gracenote.bean.User;
import io.github.jmgloria07.gracenote.bean.exception.GraceNoteUsernameNotAuthorizedException;
import io.github.jmgloria07.gracenote.dao.repository.UserRepository;
import io.github.jmgloria07.gracenote.util.mapper.UserDetailsMapper;

@Transactional
@Repository
public class DatabaseUserDao implements UserDetailsService, UserDao {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDetailsMapper userDetailsMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userWebBean = userRepository.findUserByName(username).orElseThrow(GraceNoteUsernameNotAuthorizedException::new);
		return userDetailsMapper.toUserDetails(userWebBean);
	}

	@Override
	public User login(String username, String password) {
		return userRepository.findUserByName(username)
				.orElseThrow(GraceNoteUsernameNotAuthorizedException::new);
	}

}
