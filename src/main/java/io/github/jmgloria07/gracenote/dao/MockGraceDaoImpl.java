package io.github.jmgloria07.gracenote.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.github.jmgloria07.gracenote.object.Grace;
import io.github.jmgloria07.gracenote.object.Opening;
import io.github.jmgloria07.gracenote.object.User;
import io.github.jmgloria07.gracenote.object.exception.GraceNoteUserNotFoundException;
import io.github.jmgloria07.gracenote.object.exception.GraceNoteParameterException;
import io.github.jmgloria07.gracenote.object.exception.GraceNoteServiceException;

@Component
public class MockGraceDaoImpl implements GraceDao {
	
	private static List<Grace> MOCK_DATA;
	private static List<Opening> MOCK_OPENINGS;
	private static List<User> MOCK_USERS;

	static {
		MOCK_OPENINGS = createMockOpenings();
		MOCK_USERS = createMockUsers();
		MOCK_DATA = createMockData();		
	}
	
	@Override
	public Grace getGrace(String userName, long id) {
		return MOCK_DATA.stream()
			.filter(data -> data.getId() == id 
				&& Optional.ofNullable(data.getUser()).isPresent() 
				&& data.getUser().getName().equals(userName))
			.findFirst()
			.orElseThrow(() -> new GraceNoteParameterException());
	}

	@Override
	public List<Grace> getGrace(String userName) {
		//check if user exists
		getMockUser(userName);
		
		//get graces from user
		List<Grace> response = MOCK_DATA.stream()
				.filter(data -> Optional.ofNullable(data.getUser())
						.map(User::getName)
						.get()
						.equals(userName))
				.collect(Collectors.toList());
		
		return response;
	}
	
	private static List<Grace> createMockData() {
		return Arrays.asList(
			createMockGrace(1, "user1", 1, "I created this mock dao"),
			createMockGrace(2, "user1", 1, "the support I received"),
			createMockGrace(3, "user2", 3, "yep")	
		);
		
	}
	
	private static Grace createMockGrace(long id, String user, long openingId, String text) {
		Grace result = new Grace();
		result.setId(id);
		result.setUser(getMockUser(user));
		result.setOpening(getMockOpening(openingId));
		result.setText(text);
		return result;
	}
	
	private static List<User> createMockUsers() {
		return Arrays.asList(
			new User("user1"),
			new User("user2"),
			new User("user3")
		);
	}
	
	//get a user
	//throw a runtime exception if user doesn't exist
	private static User getMockUser(String userName) {
		return MOCK_USERS.stream()
				.filter(user->user.getName().equals(userName))
				.findFirst().orElseThrow(() -> new GraceNoteUserNotFoundException());
	}

	private static List<Opening> createMockOpenings() {
		return Arrays.asList(
			new Opening(1, "I'm thankful that"),
			new Opening(2, "Gratitudes to"),
			new Opening(3, "Thanks to"),
			new Opening(4, "I'm agog that")
		);
	}
	
	private static Opening getMockOpening(long id) {
		return MOCK_OPENINGS.stream()
				.filter(opening -> opening.getId() == id)
				.findFirst().orElseThrow(() -> new GraceNoteServiceException());
	}

}
