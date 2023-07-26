package org.myself.client.exception;

import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

public class MyResponseExceptionMapper implements ResponseExceptionMapper<RuntimeException> {
    @Override
    public RuntimeException toThrowable(Response response) {
        if (response.getStatus() == 500){
            throw new RuntimeException("The Remote Service Responded with HTTP 500");
        }
        return null;
    }
}
