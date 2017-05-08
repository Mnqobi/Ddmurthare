/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.periodictable.validate;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author mnqobi
 */
@Path("validate")
public class ElementValidatorService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ValidateService
     */
    public ElementValidatorService() {
    }

    /**
     * Retrieves representation of an instance of rest.periodictable.ElementValidatorService
     * @param element Element name you wish to validate
     * @param symbol the symbol you'd like to validate against
     * @return an instance of javax.ws.rs.core.Response
     */
    @GET
    @Path("{element}/{symbol}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(
            @PathParam("element") String element,
            @PathParam("symbol") String symbol ) 
    {
        boolean validateSymbol = ElementValidator.validateSymbol(element, symbol);
        return Response.status(Response.Status.OK).entity( String.format(
              "{ \"element\" : \"%s\", \"symbol\" : \"%s\", \"valid\"  : \"%s\" }" , 
                element, symbol, validateSymbol)).build();
    }
}
