package ExceptionResponse;

import jakarta.persistence.NoResultException;
import jakarta.persistence.QueryTimeoutException;
import jakarta.ws.rs.core.Response;

public class RuntimeExceptionResponse {

    public Response getExceptionResponse(RuntimeException e) {
        if(e instanceof QueryTimeoutException)
            return Response.status(Response.Status.GATEWAY_TIMEOUT).entity(e.getMessage()).build();
        else if(e instanceof NoResultException)
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    }
}
