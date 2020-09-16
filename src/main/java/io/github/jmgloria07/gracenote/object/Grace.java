package io.github.jmgloria07.gracenote.object;

public class Grace {
	private long id;
	private Opening opening;
	private String text;
	private User user;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Opening getOpening() {
		return opening;
	}
	public void setOpening(Opening opening) {
		this.opening = opening;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
