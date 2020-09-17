package io.github.jmgloria07.gracenote.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.github.jmgloria07.gracenote.dao.OpeningDao;

import static org.mockito.Mockito.*;

public class OpeningServiceImplTest {
	private static OpeningServiceImpl unit;
	
	@BeforeAll
	public static void init() {
		unit = new OpeningServiceImpl();
		
		unit.openingDao = mock(OpeningDao.class);
	}
	
	@Test
	public void testGetOpenings() {
		//just make sure it doesn't throw unnecessary exceptions
		unit.getOpenings();
	}
	
	@Test
	public void testGetSingleOpening() {
		//just make sure it doesn't throw unnecessary exceptions
		unit.getOpening(1L);
	}
	
	@AfterAll
	public static void destroy() {
		unit = null;
	}
}
