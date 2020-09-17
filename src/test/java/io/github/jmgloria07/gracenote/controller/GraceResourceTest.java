package io.github.jmgloria07.gracenote.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import io.github.jmgloria07.gracenote.object.Grace;
import io.github.jmgloria07.gracenote.object.web.GraceForm;
import io.github.jmgloria07.gracenote.service.GraceService;

public class GraceResourceTest {
	private static GraceResource unit;
	
	private static final Grace MOCK_GRACE = new Grace();
	private static final List<Grace> MOCK_GRACE_LIST = new ArrayList<Grace>();
	
	private static final long MOCK_USER_ID = 1L;
	private static final long MOCK_ID = 1L;
	
	@BeforeAll
	public static void init() {
		unit = new GraceResource();
		unit.graceService = mock(GraceService.class);
		
		doReturn(MOCK_GRACE).when(unit.graceService).getGrace(anyLong(), anyLong());
		doReturn(MOCK_GRACE_LIST).when(unit.graceService).getGrace(anyLong());
		doReturn(MOCK_GRACE).when(unit.graceService).postGrace(anyLong(), any(GraceForm.class));
	}
	
	@Test
	public void testGetSingleGrace() {
		assertNotNull(unit.getGrace(MOCK_USER_ID));
	}
	
	@Test
	public void testGetGraceList() {
		assertNotNull(unit.getGrace(MOCK_USER_ID, MOCK_ID));
	}
	
	@Test
	public void testPostGrace() {
		GraceForm graceParam = new GraceForm();
		assertNotNull(unit.postGrace(MOCK_USER_ID, graceParam));
	}
	
	@AfterAll
	public static void destroy() {
		unit = null;
	}
}
