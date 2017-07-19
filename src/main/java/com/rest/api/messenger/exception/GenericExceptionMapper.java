package com.rest.api.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	public GenericExceptionMapper() {
		
	}

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage msg = new ErrorMessage();
		msg.setErrorMessage(exception.getMessage());
		msg.setErrorCode(500);
		msg.setDescription(exception.getLocalizedMessage());
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(msg)
				.build();
	}

}
