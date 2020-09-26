package io.github.jmgloria07.gracenote.bean.web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class GraceForm {
	
	@NotNull(message = "This field cannot be null.")
	@Min(value = 1, message = "This field should not be blank.")
	@Max(value = 10000, message = "Please limit to 10000 characters.")
	private String displayText;
	
	private long opening;
	
	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	public long getOpening() {
		return opening;
	}

	public void setOpening(long opening) {
		this.opening = opening;
	}
}
