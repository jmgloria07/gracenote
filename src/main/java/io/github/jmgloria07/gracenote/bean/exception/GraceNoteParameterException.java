package io.github.jmgloria07.gracenote.bean.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class GraceNoteParameterException extends GraceNoteServiceException {

	public GraceNoteParameterException() {
		super();
	}
	
	public GraceNoteParameterException(Exception e) {
		super(e);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8542814898717525251L;

}
