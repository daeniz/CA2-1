/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Company;
import facade.CompanyFacade;
import facade.ICompanyFacade;
import facade.IPersonFacade;
import facade.PersonFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author dennisschmock
 */
@Path("company")
public class CompanyService {

    @Context
    private UriInfo context;
    private ICompanyFacade comFacade = new CompanyFacade(Persistence.createEntityManagerFactory("PU"));
    private IPersonFacade perFacade = new PersonFacade(Persistence.createEntityManagerFactory("PU"));
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Creates a new instance of CompanyService
     */
    public CompanyService() {
    }

    @GET
    @Path("complete")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCompaniesComplete() {
        List<Company> companies = new ArrayList();
        companies = comFacade.getCompanies();
        return gson.toJson(companies);
    }
    
    @GET
    @Path("complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCompanyComplete(@PathParam("id")String id) {
        List<Company> companies = new ArrayList();
       companies = comFacade.getCompanies();
        return gson.toJson("ddd");
    }
}
