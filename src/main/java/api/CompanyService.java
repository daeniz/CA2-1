/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.CityInfo;
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
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import util.JSONConverter;

/**
 * REST Web Service
 *
 * @author dennisschmock
 */
@Path("company")
public class CompanyService {

    @Context
    private UriInfo context;
    private static ICompanyFacade comFacade = new CompanyFacade(Persistence.createEntityManagerFactory("PU"));
    private static IPersonFacade perFacade = new PersonFacade(Persistence.createEntityManagerFactory("PU"));
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static JSONConverter jsc = new JSONConverter();

    /**
     * Creates a new instance of CompanyService
     */
    public CompanyService() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=Cp1252")
    public String getDefaultResponse() {

        return gson.toJson("defaultResponse");
    }

    @GET
    @Path("complete")
    @Produces(MediaType.APPLICATION_JSON + ";charset=Cp1252")
    public String getAllCompanies() {
        List<Company> companies;
        companies = comFacade.getCompanies();
        return jsc.companiesJson(companies);
    }

    @GET
    @Path("complete/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=Cp1252")
    public String getCompanyComplete(@PathParam("id") int id) {
        Company com = comFacade.getCompany(id);

        return jsc.companyJson(com);
    }

    @GET
    @Path("contactinfo")
    @Produces(MediaType.APPLICATION_JSON + ";charset=Cp1252")
    public String getCompaniesContactInfo() {
        return jsc.companiesContactInfo(comFacade.getCompanies());
    }

    @GET
    @Path("contactinfo/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=Cp1252")
    public String getCompaniesContactInfo(@PathParam("id") int id) {
        return jsc.companyContactInfo(comFacade.getCompany(id));
    }

    @GET
    @Path("complete/zip/{zip}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=Cp1252")
    public String getCompaniesInACity(@PathParam("zip") int zip) {
        List<Company> companies;
        companies = comFacade.getCompanies(zip);
        return jsc.companiesJson(companies);
    }

    @GET
    @Path("zip")
    @Produces(MediaType.APPLICATION_JSON + ";charset=Cp1252")
    public String getZipCodes(@PathParam("zip") int zip) {
        List<CityInfo> zips;
        zips = comFacade.getZipcodes();
        return gson.toJson(zips);
        
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=Cp1252")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createCompany(String json) {
        Company com = jsc.createCompany(json);
        return jsc.companyJson(comFacade.createCompany(com));
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON + ";charset=Cp1252")
    @Consumes(MediaType.APPLICATION_JSON)
    public String editCompany(String json) {
        Company com = jsc.createCompany(json);
        System.out.println(com.getId());
        System.out.println(com.getCvr());
        return jsc.companyJson(comFacade.editCompany(com));
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=Cp1252")
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteCompany(@PathParam("id") int id) {
        return jsc.companyJson(comFacade.deleteCompany(id));
    }

}
