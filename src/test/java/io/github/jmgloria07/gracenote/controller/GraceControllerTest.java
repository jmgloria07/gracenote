package io.github.jmgloria07.gracenote.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import io.github.jmgloria07.gracenote.object.Grace;
import io.github.jmgloria07.gracenote.service.GraceService;

public class GraceControllerTest {
	private static GraceController unit;
	
	private static final Grace MOCK_GRACE = new Grace();
	private static final List<Grace> MOCK_GRACE_LIST = new ArrayList<Grace>();
	
	private static final String MOCK_USER = "user";
	private static final String MOCK_ID = "1";
	
	@BeforeAll
	public static void init() {
		unit = new GraceController();
		unit.graceService = mock(GraceService.class);
		
		doReturn(MOCK_GRACE).when(unit.graceService).getGrace(anyString(), anyString());
		doReturn(MOCK_GRACE_LIST).when(unit.graceService).getGrace(anyString());
	}
	
	@Test
	public void testGetSingleGrace() {
		assertNotNull(unit.getGrace(MOCK_USER));
	}
	
	@Test
	public void testGetGraceList() {
		assertNotNull(unit.getGrace(MOCK_USER, MOCK_ID));
	}
	
	@AfterAll
	public static void destroy() {
		unit = null;
	}
}
