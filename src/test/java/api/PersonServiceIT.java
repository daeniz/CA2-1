/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import entity.Person;
import facade.IPersonFacade;
import facade.PersonFacade;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.parsing.Parser;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Ignore;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 *
 * @author edipetres
 */
public class PersonServiceIT {
    
    int personID;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    IPersonFacade pf = new PersonFacade(emf);
    Person person;

    public PersonServiceIT() {
    }

        @BeforeClass
    public static void setUpBeforeAll() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "CA2/api/person";
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllPersonsComplete method, of class PersonService.
     */
    @Test
    @Ignore
    public void serverIsRunning() {
        given().
                when().get("/complete").
                then().
                statusCode(200);
    }

    @Test
    @Ignore
    public void testGetAllPersonsComplete() {
        
        given().
                when().get("/complete").
            then().
                body(matchesJsonSchemaInClasspath("completeInfoJsonSchema.json"));
                
    }

    /**
     * Test of getPersonCompleteWithID method, of class PersonService.
     */
    @Test
    
    public void testGetPersonCompleteWithID() {
        person = pf.addPerson(new Person("Edmond", "Petres"));
        personID = person.getId();
        System.out.println("id used for person: "+20);
        given().pathParam("id", 20).
            when().
                get("/complete/{id}").
            then().
                statusCode(200).
                body("firstName", equalTo(person.getFirstName()));
    }

    /**
     * Test of getAllPersonsContactinfo method, of class PersonService.
     */
    @Test
    public void testGetAllPersonsContactinfo() {
//        System.out.println("getAllPersonsContactinfo");
//        PersonService instance = new PersonService();
//        String expResult = "";
//        String result = instance.getAllPersonsContactinfo();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonContactinfoWithID method, of class PersonService.
     */
    @Test
    public void testGetPersonContactinfoWithID() {
//        System.out.println("getPersonContactinfoWithID");
//        int id = 0;
//        PersonService instance = new PersonService();
//        String expResult = "";
//        String result = instance.getPersonContactinfoWithID(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllPersonsWithHobby method, of class PersonService.
     */
    @Test
    public void testGetAllPersonsWithHobby() {
//        System.out.println("getAllPersonsWithHobby");
//        String hobby = "";
//        PersonService instance = new PersonService();
//        String expResult = "";
//        String result = instance.getAllPersonsWithHobby(hobby);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonWithZip method, of class PersonService.
     */
    @Test
    public void testGetPersonWithZip() {
//        System.out.println("getPersonWithZip");
//        String zip = "";
//        PersonService instance = new PersonService();
//        String expResult = "";
//        String result = instance.getPersonWithZip(zip);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonWithPhone method, of class PersonService.
     */
    @Test
    public void testGetPersonWithPhone() {
//        System.out.println("getPersonWithPhone");
//        String phone = "";
//        PersonService instance = new PersonService();
//        String expResult = "";
//        String result = instance.getPersonWithPhone(phone);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
