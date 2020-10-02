package io.github.jmgloria07.gracenote.util.mapper;

import org.springframework.stereotype.Component;

import io.github.jmgloria07.gracenote.bean.Grace;
import io.github.jmgloria07.gracenote.bean.Opening;
import io.github.jmgloria07.gracenote.bean.User;
import io.github.jmgloria07.gracenote.bean.exception.GraceNoteParameterException;
import io.github.jmgloria07.gracenote.bean.web.GraceForm;

@Component
public class GraceFormToEntityMapper implements FormToEntityMapper<GraceForm, Grace> {

	private long userId;
	
	public GraceFormToEntityMapper withUserId(long userId) {
		this.userId = userId; 
		return this;
	}
	
	@Override
	public Grace mapFormToEntity(GraceForm form) {	
		if (this.userId == 0) 
			throw new GraceNoteParameterException();
		
		Grace result = new Grace();
		result.setText(form.getDisplayText());
		
		Opening openingResult = new Opening();
		openingResult.setId(form.getOpening());
		result.setOpening(openingResult);
		
		User userResult = new User();
		userResult.setId(this.userId);
		result.setUser(userResult);
		
		//together with the control codes at the start of this
		//method, these force the method consumer to set the user
		this.userId = 0; 
		
		return result;
	}

}
