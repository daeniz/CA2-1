/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danie
 */
public class PersonFacadeTest {
    
    public PersonFacadeTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetPerson() {
        System.out.println("getPerson");
        int id = 0;
        PersonFacade instance = new PersonFacade();
        Person expResult = null;
        Person result = instance.getPerson(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPersons() {
        System.out.println("getPersons");
        PersonFacade instance = new PersonFacade();
        List<Person> expResult = null;
        List<Person> result = instance.getPersons();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPersons_int() {
        System.out.println("getPersons");
        int zipCode = 0;
        PersonFacade instance = new PersonFacade();
        List<Person> expResult = null;
        List<Person> result = instance.getPersons(zipCode);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPersons_Hobby() {
        System.out.println("getPersons");
        Hobby hobby = null;
        PersonFacade instance = new PersonFacade();
        List<Person> expResult = null;
        List<Person> result = instance.getPersons(hobby);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPerson_Phone() {
        System.out.println("getPerson");
        Phone phone = null;
        PersonFacade instance = new PersonFacade();
        Person expResult = null;
        Person result = instance.getPerson(phone);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddPhone() {
        System.out.println("addPhone");
        Phone phone = null;
        Person p = null;
        PersonFacade instance = new PersonFacade();
        Person expResult = null;
        Person result = instance.addPhone(phone, p);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddHobby() {
        System.out.println("addHobby");
        Hobby h = null;
        Person p = null;
        PersonFacade instance = new PersonFacade();
        Person expResult = null;
        Person result = instance.addHobby(h, p);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSearchPersons() {
        System.out.println("searchPersons");
        String search = "";
        PersonFacade instance = new PersonFacade();
        List<Person> expResult = null;
        List<Person> result = instance.searchPersons(search);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddPerson() {
        System.out.println("addPerson");
        Person person = null;
        PersonFacade instance = new PersonFacade();
        Person expResult = null;
        Person result = instance.addPerson(person);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEditPerson() {
        System.out.println("editPerson");
        Person person = null;
        PersonFacade instance = new PersonFacade();
        Person expResult = null;
        Person result = instance.editPerson(person);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeletePerson() {
        System.out.println("deletePerson");
        int id = 0;
        PersonFacade instance = new PersonFacade();
        Person expResult = null;
        Person result = instance.deletePerson(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        PersonFacade instance = new PersonFacade();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
