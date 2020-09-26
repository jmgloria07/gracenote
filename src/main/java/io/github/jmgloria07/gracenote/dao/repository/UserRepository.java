package io.github.jmgloria07.gracenote.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.github.jmgloria07.gracenote.bean.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT user FROM User user WHERE user.name = ?1")
	public Optional<User> findUserByName(String name);
}
