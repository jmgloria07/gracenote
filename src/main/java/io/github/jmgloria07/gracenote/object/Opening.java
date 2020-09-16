package io.github.jmgloria07.gracenote.object;

public class Opening {
	private long id;
	private String displayText;
	
	public Opening(long id, String displayText) {
		super();
		this.id = id;
		this.displayText = displayText;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDisplayText() {
		return displayText;
	}
	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}
}
