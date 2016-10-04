/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author edipetres
 */
@Path("person")
public class ApiResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ApiResource
     */
    public ApiResource() {
    }

    /**
     * Retrieves representation of an instance of api.ApiResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("complete")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPersonsComplete() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Path("complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonCompleteWithID(@PathParam("id") int id) {
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Path("contactinfo")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPersonsContactinfo() {
        throw new UnsupportedOperationException();
    }
    
    
    @GET
    @Path("contactinfo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonContactinfoWithID(@PathParam("id") int id) {
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Path("{hobby}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPersonsWithHobby(@PathParam("hobby") String hobby) {
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("person/complete/{phone}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonWithPhone(@PathParam("phone") String phone) {
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Path("person/complete/{zip}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonWithZip(@PathParam("zip") String phone) {
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Path("person/search/{searchstring}")
    @Produces(MediaType.APPLICATION_JSON)
    public String smartSearch(@PathParam("searchstring") String searchStr) {
        throw new UnsupportedOperationException();
    }
    
    
    
    
    @GET
    @Path("company/complete")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCompaniesComplete() {
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Path("company/complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCompanyCompleteWithID(@PathParam("id") int id) {
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Path("company/complete/{zip}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCompanyCompleteWithZip(@PathParam("zip") int zip) {
        throw new UnsupportedOperationException();
    }
    
    
    @GET
    @Path("company/contactinfo")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCompaniesContactinfo() {
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Path("company/contactinfo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCompanyContactinfoWithID(@PathParam("id") int id) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * PUT method for updating or creating an instance of ApiResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
