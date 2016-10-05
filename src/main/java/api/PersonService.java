/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Company;
import entity.Person;
import entity.Phone;
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
import util.PersonConverter;
import util.SmartSearch;

/**
 * REST Web Service
 *
 * @author dennisschmock
 */
@Path("person")
public class PersonService {

    @Context
    private UriInfo context;
    
    private IPersonFacade perFacade = new PersonFacade(Persistence.createEntityManagerFactory("PU"));
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private PersonConverter perConv = new PersonConverter();
    private SmartSearch ss = new SmartSearch();

    /**
     * Creates a new instance of PersonService
     */
    public PersonService() {
    }
    
    
    @GET
    @Path("complete")
    @Produces(MediaType.APPLICATION_JSON + ";charset=Cp1252")
    public String getAllPersonsComplete() {
        List<Person> persons = perFacade.getPersons();
        return perConv.personsToJson(persons);
    }

    //I create a single person list, so that I can use the same method in the converter 
    @GET
    @Path("complete/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=Cp1252")
    public String getPersonCompleteWithID(@PathParam("id") int id) {
        return perConv.personToJson(perFacade.getPerson(id));
        
    }
//    

    @GET
    @Path("contactinfo")
    @Produces(MediaType.APPLICATION_JSON + ";charset=Cp1252")
    public String getAllPersonsContactinfo() {
        List<Person> persons = perFacade.getPersons();
        return perConv.personsContactinfoToJson(persons);
    }
//  
    
    @GET
    @Path("contactinfo/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=Cp1252")
    public String getPersonContactinfoWithID(@PathParam("id") int id) {
        
        return perConv.personContactinfoToJson(perFacade.getPerson(id));
    }
//    

    @GET
    @Path("{hobby}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=Cp1252")
    public String getAllPersonsWithHobby(@PathParam("hobby") String hobby) {
        throw new UnsupportedOperationException();
    }

    
    @GET
    @Path("complete/zip/{zip}")
    @Produces(MediaType.APPLICATION_JSON+ ";charset=Cp1252")
    public String getPersonWithZip(@PathParam("zip") String zip) {
        int zipCode = Integer.parseInt(zip);
        List<Person> persons = perFacade.getPersons(zipCode);
        return perConv.personsToJson(persons);
    }
    
    @GET
    @Path("complete/phone/{phone}")
    @Produces(MediaType.APPLICATION_JSON+ ";charset=Cp1252")
    public String getPersonWithPhone(@PathParam("phone") String phone) {
        throw new UnsupportedOperationException();
//        int phoneNo = Integer.parseInt(phone);
//        return perConv.personToJson(perFacade.getPerson(new Phone(phoneNo)));
    }
    
    
    @GET
    @Path("search/{searchstring}")
    @Produces(MediaType.APPLICATION_JSON)
    public String smartSearch(@PathParam("searchstring") String searchStr) {
        List<Person> persons = ss.search(searchStr);
        return perConv.personsToJson(persons);
    }

}
