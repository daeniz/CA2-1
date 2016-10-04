/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import entity.Company;
import entity.Phone;
import facade.CompanyFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author dennisschmock
 */
public class JSONConverter {
    
    private Gson gson = new Gson();
    
    public String companyJson(Company company) {
        JsonObject com = new JsonObject();
        com.addProperty("name", company.getName());
        com.addProperty("cvr", company.getCvr());
        com.addProperty("mail", company.getEmail());
        com.addProperty("description", company.getDescription());
        com.addProperty("numemployees", company.getNumEmployees());
        com.addProperty("marketvalue", company.getMarketValue());
        com.addProperty("street", company.getAddress().getStreet());
        com.addProperty("additionalinfo", company.getAddress().getAdditionalInfo());
        com.addProperty("zip", company.getAddress().getCityInfo().getZipCode());
        com.addProperty("city", company.getAddress().getCityInfo().getCity());
        List<Phone> phoneList = company.getPhones();
        List<JsonObject> phones = new ArrayList();
        for (Phone p : phoneList) {
            JsonObject phone = new JsonObject();
            phone.addProperty("number", p.getNumber());
            phone.addProperty("description", p.getDescription());
            phones.add(phone);
        }
        com.addProperty("phones", gson.toJson(phones));
        


        
        return gson.toJson(com);
    }
    
    public String companiesJson(List<Company> companies){
        List<String> companiesJson = new ArrayList();
        for (Company company : companies) {
            companiesJson.add(this.companyJson(company));
        }
        return companiesJson(companies);
        
    
    };
    
}
