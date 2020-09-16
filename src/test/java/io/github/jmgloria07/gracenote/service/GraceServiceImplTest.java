package io.github.jmgloria07.gracenote.service;

import io.github.jmgloria07.gracenote.dao.GraceDao;
import io.github.jmgloria07.gracenote.object.Grace;
import io.github.jmgloria07.gracenote.object.exception.GraceNoteParameterException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GraceServiceImplTest {

	private static GraceServiceImpl unit;
	
	private static final String MOCK_USER = "user";
	private static final String MOCK_VALID_ID = "1";
	private static final String MOCK_INVALID_ID = "NOT_A_VALID_ID";//unparsable to long
	
	@BeforeAll
	public static void init() {
		unit = new GraceServiceImpl();
		unit.graceDao = mock(GraceDao.class);
		
		doReturn(new ArrayList<>()).when(unit.graceDao).getGrace(anyString());
		doReturn(new Grace()).when(unit.graceDao).getGrace(anyString(), anyLong());
	}
	
	@Test
	public void testValidId() {
		assertNotNull(unit.getGrace(MOCK_USER, MOCK_VALID_ID));
	}
	
	@Test
	public void testInvalidId() {
		assertThrows(GraceNoteParameterException.class, 
				() -> unit.getGrace(MOCK_USER, MOCK_INVALID_ID));
	}
	
	@Test
	public void testGetGraceList() {
		assertNotNull(unit.getGrace(MOCK_USER));
	}
	
	@AfterAll
	public static void destroy() {
		
	}
}
