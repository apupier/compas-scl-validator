// SPDX-FileCopyrightText: 2021 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0
package org.lfenergy.compas.scl.validator.rest.exception;

import org.lfenergy.compas.core.commons.model.ErrorResponse;
import org.lfenergy.compas.scl.validator.exception.NsdocFileNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NsdocNotFoundExceptionHandler implements ExceptionMapper<NsdocFileNotFoundException> {
    @Override
    public Response toResponse(NsdocFileNotFoundException exception) {
        var response = new ErrorResponse();
        response.addErrorMessage(exception.getErrorCode(), exception.getMessage());
        return Response.status(Response.Status.NOT_FOUND).entity(response).build();
    }
}
