/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Address;
import entity.CityInfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import org.skyscreamer.jsonassert.JSONAssert;

/**
 *
 * @author edipetres
 */
public class PersonConverterTest {

    public PersonConverterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
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
     * Test of personsToJson method, of class PersonConverter.
     */
    @Test
    public void testPersonsToJson() throws JSONException {
        System.out.println("personsToJson");
        List<Person> persons = new ArrayList<>();

        Person person = new Person("Test", "Bot");
        person.setAddress(new Address("Trongardsvej", "Additional Info", new CityInfo(2800, "Lyngby")));
        person.addHobby(new Hobby("Coding", "Fun with characters"));
        persons.add(person);

        Person person2 = new Person("Test", "Bot2");
        person2.setAddress(new Address("Emmavej", "Additional Info", new CityInfo(2500, "Valby")));
        person2.addHobby(new Hobby("Coding", "Fun with characters"));
        persons.add(person2);

        PersonConverter instance = new PersonConverter();
        String result = instance.personsToJson(persons);
        String expected = "[\n"
                + "  {\n"
                + "    \"firstName\": \"Test\",\n"
                + "    \"lastName\": \"Bot\",\n"
                + "    \"address\": {\n"
                + "      \"street\": \"Trongardsvej\",\n"
                + "      \"city\": \"Lyngby\",\n"
                + "      \"zip\": 2800\n"
                + "    },\n"
                + "    \"hobbies\": [\n"
                + "      {\n"
                + "        \"name\": \"Coding\",\n"
                + "        \"description\": \"Fun with characters\"\n"
                + "      }\n"
                + "    ]\n"
                + "  },\n"
                + "  {\n"
                + "    \"firstName\": \"Test\",\n"
                + "    \"lastName\": \"Bot2\",\n"
                + "    \"address\": {\n"
                + "      \"street\": \"Emmavej\",\n"
                + "      \"city\": \"Valby\",\n"
                + "      \"zip\": 2500\n"
                + "    },\n"
                + "    \"hobbies\": [\n"
                + "      {\n"
                + "        \"name\": \"Coding\",\n"
                + "        \"description\": \"Fun with characters\"\n"
                + "      }\n"
                + "    ]\n"
                + "  }\n"
                + "]";

        JSONAssert.assertEquals(expected, result, false);

    }

    /**
     * Test of personToJson method, of class PersonConverter.
     *
     * @throws org.json.JSONException
     */
    @Test
    public void testPersonToJson() throws JSONException {
        Person person = new Person("Test", "Bot");
        person.setAddress(new Address("Trongardsvej", "Additional Info", new CityInfo(2800, "Lyngby")));
        person.addHobby(new Hobby("Coding", "Fun with characters"));

        PersonConverter instance = new PersonConverter();
        String result = instance.personToJson(person);
        System.out.println(result);
        String expected = "{\n"
                + "  \"firstName\": \"Test\",\n"
                + "  \"lastName\": \"Bot\",\n"
                + "  \"address\": {\n"
                + "    \"street\": \"Trongardsvej\",\n"
                + "    \"city\": \"Lyngby\",\n"
                + "    \"zip\": 2800\n"
                + "  },\n"
                + "  \"hobbies\": [\n"
                + "    {\n"
                + "      \"name\": \"Coding\",\n"
                + "      \"description\": \"Fun with characters\"\n"
                + "    }\n"
                + "  ]\n"
                + "}";

        JSONAssert.assertEquals(expected, result, false);

    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testExceptionThrown() throws JSONException {
        Person person = new Person("Test", "Bot");
        person.setAddress(new Address("Trongardsvej", "Additional Info"));
        person.addHobby(new Hobby("Coding", "Fun with characters"));
        
        exception.expect(NullPointerException.class);
        
        PersonConverter instance = new PersonConverter();
        String personToJson = instance.personToJson(person);
    }

    /**
     * Test of personContactinfoToJson method, of class PersonConverter.
     */
    @Test
    public void testPersonContactinfoToJson() throws JSONException {
        List<Person> persons = new ArrayList<>();

        Person person = new Person("Test", "Bot");
        person.setAddress(new Address("Trongardsvej", "Additional Info", new CityInfo(2800, "Lyngby")));
        person.addHobby(new Hobby("Coding", "Fun with characters"));
        person.addPhone(new Phone(81905566, "mobile"));
        person.addPhone(new Phone(12558830, "landline"));
        persons.add(person);

        Person person2 = new Person("Test", "Bot2");
        person2.setAddress(new Address("Emmavej", "Additional Info", new CityInfo(2500, "Valby")));
        person2.addHobby(new Hobby("Coding", "Fun with characters"));
        person2.addPhone(new Phone(13885520, "mobile"));
        person2.addPhone(new Phone(35566280, "landline"));
        persons.add(person2);

        PersonConverter instance = new PersonConverter();
        String result = instance.personsContactinfoToJson(persons);
        String expected = "[\n"
                + "  {\n"
                + "    \"firstName\": \"Test\",\n"
                + "    \"lastName\": \"Bot\",\n"
                + "    \"street\": \"Trongardsvej\",\n"
                + "    \"additionalinfo\": \"Additional Info\",\n"
                + "    \"city\": \"Lyngby\",\n"
                + "    \"zip\": 2800,\n"
                + "    \"phones\": [\n"
                + "      {\n"
                + "        \"description\": \"mobile\",\n"
                + "        \"phoneNumber\": 81905566\n"
                + "      },\n"
                + "      {\n"
                + "        \"description\": \"landline\",\n"
                + "        \"phoneNumber\": 12558830\n"
                + "      }\n"
                + "    ]\n"
                + "  },\n"
                + "  {\n"
                + "    \"firstName\": \"Test\",\n"
                + "    \"lastName\": \"Bot2\",\n"
                + "    \"street\": \"Emmavej\",\n"
                + "    \"additionalinfo\": \"Additional Info\",\n"
                + "    \"city\": \"Valby\",\n"
                + "    \"zip\": 2500,\n"
                + "    \"phones\": [\n"
                + "      {\n"
                + "        \"description\": \"mobile\",\n"
                + "        \"phoneNumber\": 13885520\n"
                + "      },\n"
                + "      {\n"
                + "        \"description\": \"landline\",\n"
                + "        \"phoneNumber\": 35566280\n"
                + "      }\n"
                + "    ]\n"
                + "  }\n"
                + "]";

        JSONAssert.assertEquals(expected, result, false);
    }

    /**
     * Test of personsContactinfoToJson method, of class PersonConverter.
     */
    @Test
    public void testPersonsContactinfoToJson() throws JSONException {
        Person person = new Person("Test", "Bot");
        person.setAddress(new Address("Trongardsvej", "Additional Info", new CityInfo(2800, "Lyngby")));
        person.addHobby(new Hobby("Coding", "Fun with characters"));
        person.addPhone(new Phone(81905566, "mobile"));
        person.addPhone(new Phone(12558830, "landline"));

        PersonConverter instance = new PersonConverter();
        String result = instance.personContactinfoToJson(person);
        String expected = "{\n"
                + "  \"firstName\": \"Test\",\n"
                + "  \"lastName\": \"Bot\",\n"
                + "  \"street\": \"Trongardsvej\",\n"
                + "  \"additionalinfo\": \"Additional Info\",\n"
                + "  \"city\": \"Lyngby\",\n"
                + "  \"zip\": 2800,\n"
                + "  \"phones\": [\n"
                + "    {\n"
                + "      \"description\": \"mobile\",\n"
                + "      \"phoneNumber\": 81905566\n"
                + "    },\n"
                + "    {\n"
                + "      \"description\": \"landline\",\n"
                + "      \"phoneNumber\": 12558830\n"
                + "    }\n"
                + "  ]\n"
                + "}";

        JSONAssert.assertEquals(expected, result, false);
    }

}
