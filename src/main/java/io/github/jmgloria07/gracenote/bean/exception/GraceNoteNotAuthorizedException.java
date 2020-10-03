package io.github.jmgloria07.gracenote.bean.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class GraceNoteNotAuthorizedException extends GraceNoteServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5822498429535193337L;

}
