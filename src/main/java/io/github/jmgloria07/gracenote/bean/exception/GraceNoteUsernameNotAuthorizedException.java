package io.github.jmgloria07.gracenote.bean.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Exception for when username is not found
 * This should only for the sake of classifying on the app level
 * i.e. logging and should not be shown to the client.
 */
@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class GraceNoteUsernameNotAuthorizedException extends GraceNoteNotAuthorizedException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5423909787213750668L;

}
