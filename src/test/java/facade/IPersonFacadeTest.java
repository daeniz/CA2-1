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
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danie
 */
public class IPersonFacadeTest {
    
    public IPersonFacadeTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetPerson_int() {
        
        
        
        
        System.out.println("getPerson");
        int id = 0;
        IPersonFacade instance = new IPersonFacadeImpl();
        Person expResult = null;
        Person result = instance.getPerson(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPersons_0args() {
        System.out.println("getPersons");
        IPersonFacade instance = new IPersonFacadeImpl();
        List<Person> expResult = null;
        List<Person> result = instance.getPersons();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPersons_int() {
        System.out.println("getPersons");
        int zipCode = 0;
        IPersonFacade instance = new IPersonFacadeImpl();
        List<Person> expResult = null;
        List<Person> result = instance.getPersons(zipCode);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPersons_Hobby() {
        System.out.println("getPersons");
        Hobby hobby = null;
        IPersonFacade instance = new IPersonFacadeImpl();
        List<Person> expResult = null;
        List<Person> result = instance.getPersons(hobby);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPerson_Phone() {
        System.out.println("getPerson");
        Phone phone = null;
        IPersonFacade instance = new IPersonFacadeImpl();
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
        IPersonFacade instance = new IPersonFacadeImpl();
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
        IPersonFacade instance = new IPersonFacadeImpl();
        Person expResult = null;
        Person result = instance.addHobby(h, p);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSearchPersons() {
        System.out.println("searchPersons");
        String search = "";
        IPersonFacade instance = new IPersonFacadeImpl();
        List<Person> expResult = null;
        List<Person> result = instance.searchPersons(search);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddPerson() {
        System.out.println("addPerson");
        Person person = null;
        IPersonFacade instance = new IPersonFacadeImpl();
        Person expResult = null;
        Person result = instance.addPerson(person);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEditPerson() {
        System.out.println("editPerson");
        Person person = null;
        IPersonFacade instance = new IPersonFacadeImpl();
        Person expResult = null;
        Person result = instance.editPerson(person);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeletePerson() {
        System.out.println("deletePerson");
        int id = 0;
        IPersonFacade instance = new IPersonFacadeImpl();
        Person expResult = null;
        Person result = instance.deletePerson(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    public class IPersonFacadeImpl implements IPersonFacade {

        public Person getPerson(int id) {
            return null;
        }

        public List<Person> getPersons() {
            return null;
        }

        public List<Person> getPersons(int zipCode) {
            return null;
        }

        public List<Person> getPersons(Hobby hobby) {
            return null;
        }

        public Person getPerson(Phone phone) {
            return null;
        }

        public Person addPhone(Phone phone, Person p) {
            return null;
        }

        public Person addHobby(Hobby h, Person p) {
            return null;
        }

        public List<Person> searchPersons(String search) {
            return null;
        }

        public Person addPerson(Person person) {
            return null;
        }

        public Person editPerson(Person person) {
            return null;
        }

        public Person deletePerson(int id) {
            return null;
        }
    }
    
}
