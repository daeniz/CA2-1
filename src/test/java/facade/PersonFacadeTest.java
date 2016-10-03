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
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danie
 */
public class PersonFacadeTest {
    static EntityManagerFactory emf= Persistence.createEntityManagerFactory("pu_test");
    private static IPersonFacade facade;
    
    public PersonFacadeTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetPerson() {
        System.out.println("getPerson");
        int id = 0;
        facade = new PersonFacade(Persistence.createEntityManagerFactory("pu_test"));
        Person expResult = null;
        Person result = facade.getPerson(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPersons() {
        System.out.println("getPersons");
        facade = new PersonFacade(Persistence.createEntityManagerFactory("pu_test"));
        List<Person> expResult = null;
        List<Person> result = facade.getPersons();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPersons_int() {
        System.out.println("getPersons");
        int zipCode = 0;
        facade = new PersonFacade(Persistence.createEntityManagerFactory("pu_test"));
        List<Person> expResult = null;
        List<Person> result = facade.getPersons(zipCode);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPersons_Hobby() {
        System.out.println("getPersons");
        Hobby hobby = null;
        facade = new PersonFacade(Persistence.createEntityManagerFactory("pu_test"));
        List<Person> expResult = null;
        List<Person> result = facade.getPersons(hobby);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPerson_Phone() {
        System.out.println("getPerson");
        Phone phone = null;
        facade = new PersonFacade(Persistence.createEntityManagerFactory("pu_test"));
        Person expResult = null;
        Person result = facade.getPerson(phone);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddPhone() {
        System.out.println("addPhone");
        Phone phone = null;
        Person p = null;
        facade = new PersonFacade(Persistence.createEntityManagerFactory("pu_test"));
        Person expResult = null;
        Person result = facade.addPhone(phone, p);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddHobby() {
        System.out.println("addHobby");
        Hobby h = null;
        Person p = null;
        facade = new PersonFacade(Persistence.createEntityManagerFactory("pu_test"));
        Person expResult = null;
        Person result = facade.addHobby(h, p);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSearchPersons() {
        System.out.println("searchPersons");
        String search = "";
        facade = new PersonFacade(Persistence.createEntityManagerFactory("pu_test"));
        List<Person> expResult = null;
        List<Person> result = facade.searchPersons(search);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddPerson() {
        System.out.println("addPerson");
        Person person = null;
        facade = new PersonFacade(Persistence.createEntityManagerFactory("pu_test"));
        Person expResult = null;
        Person result = facade.addPerson(person);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEditPerson() {
        System.out.println("editPerson");
        Person person = null;
        facade = new PersonFacade(Persistence.createEntityManagerFactory("pu_test"));
        Person expResult = null;
        Person result = facade.editPerson(person);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeletePerson() {
        System.out.println("deletePerson");
        int id = 0;
        facade = new PersonFacade(Persistence.createEntityManagerFactory("pu_test"));
        Person expResult = null;
        Person result = facade.deletePerson(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        facade = new PersonFacade(Persistence.createEntityManagerFactory("pu_test"));
        EntityManager expResult = null;
        EntityManager result = facade.getEntityManager();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
