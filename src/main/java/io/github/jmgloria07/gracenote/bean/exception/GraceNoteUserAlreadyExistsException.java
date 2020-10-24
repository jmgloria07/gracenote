package io.github.jmgloria07.gracenote.bean.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class GraceNoteUserAlreadyExistsException extends GraceNoteServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8301499350686892989L;

}
