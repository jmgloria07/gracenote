package io.github.jmgloria07.gracenote.bean.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_IMPLEMENTED)
public class GraceNoteMethodNotSupportedException extends GraceNoteServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1494799487854990478L;

}
