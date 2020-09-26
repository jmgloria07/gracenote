package io.github.jmgloria07.gracenote.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.github.jmgloria07.gracenote.bean.Grace;

public interface GraceRepository extends JpaRepository<Grace, Long> {

	@Deprecated
	@Query("SELECT g FROM Grace g LEFT JOIN User u ON g.user = u.id WHERE u.name = ?1 AND g.id = ?2")
	public Optional<Grace> findByUserNameAndId(String user, long id);
	
	@Deprecated
	@Query("SELECT g FROM Grace g LEFT JOIN User u ON g.user = u.id WHERE u.name = ?1")
	public List<Grace> findAllByUserName(String user);
	
	@Deprecated
	@Query("SELECT g FROM Grace g WHERE g.user = ?1")
	public List<Grace> findByUserIdAndGraceId(long userId, long graceId);
	
	@Deprecated
	@Query("SELECT g FROM Grace g WHERE g.user = ?1")
	public List<Grace> findAllByUserId(long id);
	

	
}
