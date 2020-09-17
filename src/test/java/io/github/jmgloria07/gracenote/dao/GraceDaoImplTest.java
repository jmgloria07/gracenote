package io.github.jmgloria07.gracenote.dao;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Optional;

import io.github.jmgloria07.gracenote.dao.repository.GraceRepository;
import io.github.jmgloria07.gracenote.dao.repository.OpeningRepository;
import io.github.jmgloria07.gracenote.dao.repository.UserRepository;
import io.github.jmgloria07.gracenote.object.Grace;
import io.github.jmgloria07.gracenote.object.Opening;
import io.github.jmgloria07.gracenote.object.User;
import io.github.jmgloria07.gracenote.object.exception.GraceNoteNotFoundException;
import io.github.jmgloria07.gracenote.object.exception.GraceNoteParameterException;

public class GraceDaoImplTest {
	
	private static GraceDaoImpl unit;
	
	private static final long MOCK_GRACE_ID = 1L;
	private static final long MOCK_USER_ID = 1L;
	private static final long MOCK_OPENING_ID = 1L;
	
	private static final long MOCK_MISSING_GRACE_ID = 2L;
	private static final long MOCK_MISSING_USER_ID = 2L;
	private static final long MOCK_MISSING_OPENING_ID = 2L;
	
	@BeforeAll
	public static void init() {
		unit = new GraceDaoImpl();
		
		unit.graceRepository = mock(GraceRepository.class);
		unit.openingRepository = mock(OpeningRepository.class);
		unit.userRepository = mock(UserRepository.class);
		
		User userWithGrace = new User();
		Grace validGrace = new Grace();
		validGrace.setId(MOCK_GRACE_ID);
		userWithGrace.setGraces(Arrays.asList(validGrace));
				
		doReturn(validGrace).when(unit.graceRepository).save(any(Grace.class));
		doReturn(null).when(unit.graceRepository).save(null);
		
		doReturn(Optional.ofNullable(null)).when(unit.userRepository).findById(MOCK_MISSING_USER_ID);
		doReturn(Optional.of(userWithGrace)).when(unit.userRepository).findById(MOCK_USER_ID);
		
		doReturn(Optional.ofNullable(null)).when(unit.openingRepository).findById(MOCK_MISSING_OPENING_ID);		
		doReturn(Optional.of(new Opening())).when(unit.openingRepository).findById(MOCK_OPENING_ID);
	}
	
	//user is found and grace is retrieved from the user
	@Test
	public void testValidGetSingleGrace() {
		assertNotNull(unit.getGrace(MOCK_USER_ID, MOCK_GRACE_ID));
	}
	
	//user is missing
	@Test
	public void testMissingUserGetSingleGrace() {
		assertThrows(GraceNoteNotFoundException.class, () -> unit.getGrace(MOCK_MISSING_USER_ID, MOCK_GRACE_ID));
	}
	
	//user is found but grace is missing from the user
	@Test
	public void testMissingGraceGetSingleGrace() {
		assertThrows(GraceNoteNotFoundException.class, () -> unit.getGrace(MOCK_USER_ID, MOCK_MISSING_GRACE_ID));
	}
	
	//user is found and graces are retrieved from the user
	@Test
	public void testValidGetGraces() {
		assertNotNull(unit.getGrace(MOCK_USER_ID));
	}
	
	//user is missing
	@Test
	public void testMissingUserGetGraces() {
		assertThrows(GraceNoteNotFoundException.class, () -> unit.getGrace(MOCK_MISSING_USER_ID));
	}
	
	//opening and user are found from their respective set IDs.
	@Test
	public void testValidPostGrace() {		
		//create a valid parameter
		Grace graceParam = new Grace();
		Opening openingParam = new Opening();
		openingParam.setId(MOCK_OPENING_ID);
		graceParam.setOpening(openingParam);
		User userParam = new User();
		userParam.setId(MOCK_USER_ID);
		graceParam.setUser(userParam);
		
		assertNotNull(unit.postGrace(graceParam));
	}
	
	//user is missing
	@Test
	public void testMissingUserPostGrace() {
		//create a user not found parameter
		Grace graceParam = new Grace();
		Opening openingParam = new Opening();
		openingParam.setId(MOCK_OPENING_ID);
		graceParam.setOpening(openingParam);
		User userParam = new User();
		userParam.setId(MOCK_MISSING_USER_ID);
		graceParam.setUser(userParam);
		
		assertThrows(GraceNoteNotFoundException.class, () -> unit.postGrace(graceParam));
	}
	
	//opening is missing
	@Test
	public void testMissingOpeningPostGrace() {
		//create an opening not found parameter
		Grace graceParam = new Grace();
		Opening openingParam = new Opening();
		openingParam.setId(MOCK_MISSING_OPENING_ID);
		graceParam.setOpening(openingParam);
		User userParam = new User();
		userParam.setId(MOCK_USER_ID);
		graceParam.setUser(userParam);
		
		assertThrows(GraceNoteNotFoundException.class, () -> unit.postGrace(graceParam));
	}
	
	//null parameter
	@Test
	public void testNullParamPostGrace() {
		assertThrows(GraceNoteParameterException.class, () -> unit.postGrace(null));
	}
	
	@AfterAll
	public static void destroy() {
		unit = null;
	}
}
