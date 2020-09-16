package io.github.jmgloria07.gracenote.object.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class GraceNoteServiceException extends RuntimeException {

	public GraceNoteServiceException() {
		super();
	}
	
	public GraceNoteServiceException(Exception e) {
		super(e);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7845115495372011304L;

}
