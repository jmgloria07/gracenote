package io.github.jmgloria07.gracenote.dao;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Optional;

import io.github.jmgloria07.gracenote.bean.Opening;
import io.github.jmgloria07.gracenote.bean.exception.GraceNoteNotFoundException;
import io.github.jmgloria07.gracenote.dao.repository.OpeningRepository;

public class DatabaseOpeningDaoTest {
	private static DatabaseOpeningDao unit;
	
	private static final long MOCK_OPENING_ID = 1L;
	private static final long MOCK_MISSING_OPENING_ID = 2L;
	
	@BeforeAll
	public static void init() {
		unit = new DatabaseOpeningDao();
		
		unit.openingRepository = mock(OpeningRepository.class);
		doReturn(new ArrayList<Opening>()).when(unit.openingRepository).findAll();
		doReturn(Optional.ofNullable(null)).when(unit.openingRepository).findById(MOCK_MISSING_OPENING_ID);
		doReturn(Optional.ofNullable(new Opening())).when(unit.openingRepository).findById(MOCK_OPENING_ID);
	}
	
	@Test
	public void testGetOpenings() {
		assertNotNull(unit.getOpenings());
	}
	
	@Test
	public void testGetSingleOpeningNotFound() {
		assertThrows(GraceNoteNotFoundException.class, ()->unit.getOpening(MOCK_MISSING_OPENING_ID));
	}
	
	@Test
	public void testGetSingleOpening() {
		assertNotNull(unit.getOpening(MOCK_OPENING_ID));
	}
	
	@AfterAll
	public static void destroy() {
		unit = null;
	}
}
