package io.github.jmgloria07.gracenote.bean.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class GraceNoteNotFoundException extends GraceNoteServiceException {

	private static final long serialVersionUID = -3134554529722102927L;

}
