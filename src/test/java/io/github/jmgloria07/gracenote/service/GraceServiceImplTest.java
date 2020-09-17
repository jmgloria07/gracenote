package io.github.jmgloria07.gracenote.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.github.jmgloria07.gracenote.dao.GraceDao;
import io.github.jmgloria07.gracenote.object.Grace;

public class GraceServiceImplTest {

	private static GraceServiceImpl unit;
	
	private static final long MOCK_USER_ID = 1L;
	private static final long MOCK_VALID_ID = 1L;
	
	private static final List<Grace> MOCK_GRACE_LIST = new ArrayList<>();
	private static final Grace MOCK_GRACE = new Grace();
	
	@BeforeAll
	public static void init() {
		unit = new GraceServiceImpl();
		unit.graceDao = mock(GraceDao.class);
		
		doReturn(MOCK_GRACE_LIST).when(unit.graceDao).getGrace(anyLong());
		doReturn(MOCK_GRACE).when(unit.graceDao).getGrace(anyLong(), anyLong());
	}
	
	@Test
	public void testValidId() {
		assertNotNull(unit.getGrace(MOCK_USER_ID, MOCK_VALID_ID));
	}
	
	@Test
	public void testGetGraceList() {
		assertNotNull(unit.getGrace(MOCK_USER_ID));
	}
	
	@AfterAll
	public static void destroy() {
		
	}
}
