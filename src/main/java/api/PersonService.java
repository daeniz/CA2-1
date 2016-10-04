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
        return perConv.personToJson(persons);
    }

    //I create a single person list, so that I can use the same method in the converter 
    @GET
    @Path("complete/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=Cp1252")
    public String getPersonCompleteWithID(@PathParam("id") int id) {
        Person person = perFacade.getPerson(id);
        List<Person> personList = null;
        personList.add(person);
        return perConv.personToJson(personList);
        
    }
//    

    @GET
    @Path("contactinfo")
    @Produces(MediaType.APPLICATION_JSON + ";charset=Cp1252")
    public String getAllPersonsContactinfo() {
        List<Person> persons = perFacade.getPersons();
        return perConv.personContactinfoToJson(persons);
    }
//    
//    
    
    //I create a single person list, so that I can use the same method in the converter
    @GET
    @Path("contactinfo/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=Cp1252")
    public String getPersonContactinfoWithID(@PathParam("id") int id) {
        List<Person> persons = null;
        Person person = perFacade.getPerson(id);
        persons.add(person);
        return perConv.personContactinfoToJson(persons);
    }
//    

    @GET
    @Path("{hobby}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=Cp1252")
    public String getAllPersonsWithHobby(@PathParam("hobby") String hobby) {
        return gson.toJson("sadff");
    }

//    
//    @GET
//    @Path("complete/{zip}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getPersonWithZip(@PathParam("zip") String zip) {
//        throw new UnsupportedOperationException();
//    }
//    
//    @GET
//    @Path("search/{searchstring}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String smartSearch(@PathParam("searchstring") String searchStr) {
//        throw new UnsupportedOperationException();
//    }

}
