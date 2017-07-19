package com.rest.api.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	public DataNotFoundExceptionMapper() {
	
	}

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage msg = new ErrorMessage();
		msg.setErrorMessage(exception.getMessage());
		msg.setErrorCode(404);
		msg.setDescription("Description here.");
		return Response.status(Status.NOT_FOUND)
				.entity(msg)
				.build();
	}

	
}
