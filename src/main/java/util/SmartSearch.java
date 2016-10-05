/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Person;
import entity.Phone;
import facade.IPersonFacade;
import facade.PersonFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.StringUtils;
import org.apache.commons.lang3.StringUtils.*;

/**
 *
 * @author edipetres
 */
public class SmartSearch {

    PersonFacade pf;

    public SmartSearch() {
        pf = new PersonFacade(Persistence.createEntityManagerFactory("PU"));
    }

    public List<Person> search(String searchStr) {
        List<Person> persons = pf.getPersons();
        List<Person> result = new ArrayList<>();
        for (Person p : persons) {
            boolean add = false;

            if (org.apache.commons.lang3.StringUtils.containsIgnoreCase(p.getFirstName(), searchStr)) {
                add = true;
                //System.out.println("Found a first name ("+ p.getFirstName() +")");
            }
            if (org.apache.commons.lang3.StringUtils.containsIgnoreCase(p.getLastName(), searchStr)) {
                add = true;
                //System.out.println("Found a last name ("+ p.getLastName() +")");
            }
            if (org.apache.commons.lang3.StringUtils.containsIgnoreCase(p.getEmail(), searchStr)) {
                add = true;
                //System.out.println("Found an email ("+ p.getEmail()+")");
            }

            //If it is a number, search through the phone numbers and zips
            if (StringUtils.isNumeric(searchStr)) {
                //Search for phone numbers
                int phoneNo = Integer.parseInt(searchStr);
                for (Phone phone : p.getPhones()) {
                    if (phone.getNumber() == phoneNo) {
                        add = true;
                        //System.out.println("Found a phone number ("+ phoneNo+")");
                    }
                }
            }

            //Search for city
            if (org.apache.commons.lang3.StringUtils.containsIgnoreCase(p.getAddress().getCityInfo().getCity(), searchStr)) {
                add = true;
            }

            //Searh for zip
            String s = p.getAddress().getCityInfo().getZipCode() + "";
            if (org.apache.commons.lang3.StringUtils.containsIgnoreCase(s, searchStr)) {
                add = true;
            }

            //Search for street name
            if (org.apache.commons.lang3.StringUtils.containsIgnoreCase(p.getAddress().getStreet(), searchStr)) {
                add = true;
                //System.out.println("Found a street ("+ p.getAddress().getStreet()+")");
            }
            
            
            //If there was a match, add the person to the result list
            if (add) {
                result.add(p);
            }
        }
        return result;
    }

}
