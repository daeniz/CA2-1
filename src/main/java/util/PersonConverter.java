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
import java.util.List;

/**
 *
 * @author edipetres
 */
public class PersonConverter {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    public String personToJson(List<Person> persons) {
        JsonArray jArray = new JsonArray();
        for (Person p : persons) {
            JsonObject jo = new JsonObject();
            jo.addProperty("firstName", p.getFirstName());
            jo.addProperty("lastName", p.getLastName());
            jo.addProperty("email", p.getEmail());
            jo.addProperty("street", p.getAddress().getStreet());
            
            //adding address properties
            JsonObject address = new JsonObject();
            address.addProperty("street", p.getAddress().getStreet());
            address.addProperty("city", p.getAddress().getCityInfo().getCity());
            address.addProperty("zip", p.getAddress().getCityInfo().getZipCode());
            jo.add("address", address);
            
            //adding different hobbies
            JsonArray hobbyArray = new JsonArray();
            for (Hobby hobby : p.getHobbies()) {
                JsonObject hobbyobj = new JsonObject();
                hobbyobj.addProperty("name", hobby.getName());
                hobbyobj.addProperty("description", hobby.getDescription());
                hobbyArray.add(hobbyobj);
            }
            jArray.add(hobbyArray);
            
            jArray.add(jo);
        }
        return gson.toJson(jArray);
    }
    
}
