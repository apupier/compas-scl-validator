// SPDX-FileCopyrightText: 2022 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0
package org.lfenergy.compas.scl.validator.rest.v1;

import io.quarkus.security.Authenticated;
import org.lfenergy.compas.scl.validator.rest.v1.model.NsdocListResponse;
import org.lfenergy.compas.scl.validator.service.NsdocService;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

import static org.lfenergy.compas.scl.validator.rest.SclResourceConstants.ID_PARAM;

@Authenticated
@RequestScoped
@Path("/nsdoc/v1")
public class NsdocResource {
    private final NsdocService nsdocService;

    public NsdocResource(NsdocService nsdocService) {
        this.nsdocService = nsdocService;
    }

    @GET
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public NsdocListResponse list() {
        NsdocListResponse response = new NsdocListResponse();
        response.setNsdocFiles(nsdocService.list());
        return response;
    }

    @GET
    @Path("{" + ID_PARAM + "}")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public String get(@PathParam(ID_PARAM) UUID id) {
        return nsdocService.get(id);
    }
}