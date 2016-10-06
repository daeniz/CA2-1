/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.List;

/**
 *
 * @author edipetres
 */
public class PersonConverter {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public String personsToJson(List<Person> persons) {
        System.out.println("Starting converter");
        JsonArray jArray = new JsonArray();
        for (Person p : persons) {
            System.out.println("Adding person");
            JsonObject jo = new JsonObject();
            jo.addProperty("id", p.getId());
            jo.addProperty("firstName", p.getFirstName());
            jo.addProperty("lastName", p.getLastName());
            jo.addProperty("email", p.getEmail());

            //adding address properties
            JsonObject address = new JsonObject();
            if(p.getAddress()!=null){
            address.addProperty("street", p.getAddress().getStreet());
            address.addProperty("city", p.getAddress().getCityInfo().getCity());
            address.addProperty("zip", p.getAddress().getCityInfo().getZipCode());
            jo.add("address", address);
            }

            //adding different hobbies
            System.out.println("Before adding hobby");
            if (p.getHobbies()!=null) {
                System.out.println("Adding hobby");
                JsonArray hobbyArray = new JsonArray();
                
                for (Hobby hobby : p.getHobbies()) {
                    JsonObject hobbyobj = new JsonObject();
                    hobbyobj.addProperty("name", hobby.getName());
                    hobbyobj.addProperty("description", hobby.getDescription());
                    hobbyArray.add(hobbyobj);
                }
                jo.add("hobbies", hobbyArray);
            }
            System.out.println("Adding to array");
            jArray.add(jo);
        }
        System.out.println("Trying to output array: "+ jArray);
        return gson.toJson(jArray);
    }

    public String personToJson(Person p) {

        JsonObject jo = new JsonObject();
        jo.addProperty("id", p.getId());
        jo.addProperty("firstName", p.getFirstName());
        jo.addProperty("lastName", p.getLastName());
        jo.addProperty("email", p.getEmail());

        //adding address properties
        JsonObject address = new JsonObject();
        address.addProperty("street", p.getAddress().getStreet());
        address.addProperty("city", p.getAddress().getCityInfo().getCity());
        address.addProperty("zip", p.getAddress().getCityInfo().getZipCode());
        jo.add("address", address);

        //adding different hobbies
        if (p.getHobbies().size() > 0) {
            JsonArray hobbyArray = new JsonArray();
            for (Hobby hobby : p.getHobbies()) {
                JsonObject hobbyobj = new JsonObject();
                hobbyobj.addProperty("name", hobby.getName());
                hobbyobj.addProperty("description", hobby.getDescription());
                hobbyArray.add(hobbyobj);
            }
            jo.add("hobbies", hobbyArray);
        }

        return gson.toJson(jo);
    }

    public String personContactinfoToJson(Person person) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("firstName", person.getFirstName());
        jsonObject.addProperty("lastName", person.getLastName());
        jsonObject.addProperty("email", person.getEmail());
        jsonObject.addProperty("street", person.getAddress().getStreet());
        jsonObject.addProperty("additionalinfo", person.getAddress().getAdditionalInfo());
        jsonObject.addProperty("city", person.getAddress().getCityInfo().getCity());
        jsonObject.addProperty("zip", person.getAddress().getCityInfo().getZipCode());

        if (person.getPhones().size() > 0) {
            JsonArray phones = new JsonArray();
            for (Phone phone : person.getPhones()) {
                JsonObject jsonObjectPhone = new JsonObject();
                jsonObjectPhone.addProperty("description", phone.getDescription());
                jsonObjectPhone.addProperty("phoneNumber", phone.getNumber());
                phones.add(jsonObjectPhone);
            }
            jsonObject.add("phones", phones);
        }
        return gson.toJson(jsonObject);
    }

    public String personsContactinfoToJson(List<Person> persons) {
        JsonArray jArray = new JsonArray();
        for (Person person : persons) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("firstName", person.getFirstName());
            jsonObject.addProperty("lastName", person.getLastName());
            jsonObject.addProperty("email", person.getEmail());
            jsonObject.addProperty("street", person.getAddress().getStreet());
            jsonObject.addProperty("additionalinfo", person.getAddress().getAdditionalInfo());
            jsonObject.addProperty("city", person.getAddress().getCityInfo().getCity());
            jsonObject.addProperty("zip", person.getAddress().getCityInfo().getZipCode());

            if (person.getPhones().size() > 0) {
                JsonArray phones = new JsonArray();
                for (Phone phone : person.getPhones()) {
                    JsonObject jsonObjectPhone = new JsonObject();
                    jsonObjectPhone.addProperty("description", phone.getDescription());
                    jsonObjectPhone.addProperty("phoneNumber", phone.getNumber());
                    phones.add(jsonObjectPhone);
                }
                jsonObject.add("phones", phones);
            }
            jArray.add(jsonObject);
        }
        return gson.toJson(jArray);
    }

}
