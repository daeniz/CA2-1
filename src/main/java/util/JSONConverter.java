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
import com.google.gson.JsonParser;
import entity.Address;
import entity.CityInfo;
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

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public String companyJson(Company company) {
        if (company == null) {
            return "";
        }
        JsonObject com = new JsonObject();
        com.addProperty("id", company.getId());
        com.addProperty("name", company.getName());
        com.addProperty("cvr", company.getCvr());
        com.addProperty("mail", company.getEmail());
        com.addProperty("description", company.getDescription());
        com.addProperty("numemployees", company.getNumEmployees());
        com.addProperty("marketvalue", company.getMarketValue());
        if (company.getAddress() != null) {
            com.addProperty("street", company.getAddress().getStreet());
            com.addProperty("additionalinfo", company.getAddress().getAdditionalInfo());
            com.addProperty("zip", company.getAddress().getCityInfo().getZipCode());
            com.addProperty("city", company.getAddress().getCityInfo().getCity());
        }

        List<Phone> phoneList = company.getPhones();
        if (phoneList != null) {
            JsonArray phones = new JsonArray();
            for (Phone p : phoneList) {
                JsonObject phone = new JsonObject();
                phone.addProperty("number", p.getNumber());
                phone.addProperty("description", p.getDescription());
                phones.add(phone);
            }
            com.add("phones", phones);
        }

        return gson.toJson(com);

    }

    public JsonObject companyJsonObject(Company company) {
        JsonObject com = new JsonObject();
        com.addProperty("name", company.getName());
        com.addProperty("cvr", company.getCvr());
        com.addProperty("email", company.getEmail());
        com.addProperty("description", company.getDescription());
        com.addProperty("numEmployees", company.getNumEmployees());
        com.addProperty("marketValue", company.getMarketValue());
        if (company.getAddress() != null) {
            com.addProperty("street", company.getAddress().getStreet());
            com.addProperty("additionalinfo", company.getAddress().getAdditionalInfo());
            com.addProperty("zip", company.getAddress().getCityInfo().getZipCode());
            com.addProperty("city", company.getAddress().getCityInfo().getCity());
        }

        List<Phone> phoneList = company.getPhones();
        if (phoneList != null) {
            JsonArray phones = new JsonArray();
            for (Phone p : phoneList) {
                JsonObject phone = new JsonObject();
                phone.addProperty("number", p.getNumber());
                phone.addProperty("description", p.getDescription());
                phones.add(phone);
            }
            com.add("phones", phones);

        }

        return com;
    }

    public String companiesJson(List<Company> companies) {
        if (companies == null) {
            return "";
        }
        JsonArray companiesJson = new JsonArray();
        for (Company company : companies) {
            JsonObject json = companyJsonObject(company);
            companiesJson.add(json);
        }
        return gson.toJson(companiesJson);

    }

    ;

    public String companyContactInfo(Company company) {
        if(company==null)return"";
        JsonObject com = new JsonObject();
        com.addProperty("name", company.getName());
        com.addProperty("email", company.getEmail());

        List<Phone> phoneList = company.getPhones();
        if (phoneList != null) {
            JsonArray phones = new JsonArray();
            for (Phone p : phoneList) {
                JsonObject phone = new JsonObject();
                phone.addProperty("number", p.getNumber());
                phone.addProperty("description", p.getDescription());
                phones.add(phone);
            }
            com.add("phones", phones);

        }
        return gson.toJson(com);
    }
    
     public JsonObject companyContactInfoJson(Company company) {
        JsonObject com = new JsonObject();
          if(company==null)return com;
        com.addProperty("name", company.getName());
        com.addProperty("email", company.getEmail());

        List<Phone> phoneList = company.getPhones();
        if (phoneList != null) {
            JsonArray phones = new JsonArray();
            for (Phone p : phoneList) {
                JsonObject phone = new JsonObject();
                phone.addProperty("number", p.getNumber());
                phone.addProperty("description", p.getDescription());
                phones.add(phone);
            }
            com.add("phones", phones);

        }
        return com;
    }

    public String companiesContactInfo(List<Company> companies) {
        if (companies == null) {
            return "";
        }
        JsonArray companiesJson = new JsonArray();
        for (Company company : companies) {
            JsonObject json = companyContactInfoJson(company);
            companiesJson.add(json);
        }
        return gson.toJson(companiesJson);
    }
    
    public Company createCompany(String json){
        JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
        Company company = gson.fromJson(json, Company.class);
        List<Phone> phones = company.getPhones();
        if(phones!=null){
            for (Phone phone : phones) {
                phone.setInfoEntity(company);
            }
        }
        CityInfo ci = new CityInfo(obj.get("zip").getAsInt(), obj.get("city").getAsString());
        Address address = new Address(obj.get("street").getAsString(),obj.get("description").getAsString(),ci);
        company.setAddress(address);
        return company;
    }

}
