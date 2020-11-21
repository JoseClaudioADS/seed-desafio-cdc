package br.com.desafio01.common.handlers;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Set;

@Provider
public class BadRequestExceptionHandler implements ExceptionMapper<BadRequestException> {
    @Override
    public Response toResponse(BadRequestException exception) {
        ErrorHandlerVO responseEntity = new ErrorHandlerVO(Set.of(exception.getMessage()));
        return Response.status(Response.Status.BAD_REQUEST).entity(responseEntity).build();
    }

}
