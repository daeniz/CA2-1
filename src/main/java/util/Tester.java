/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.CityInfo;
import entity.Person;
import facade.IPersonFacade;
import facade.PersonFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author edipetres
 */
public class Tester {

    public static void main(String[] args) {
        SmartSearch ss = new SmartSearch();
        List<Person> persons = ss.search("80489716");
        if (persons != null) {
            for (Person p : persons) {
                System.out.println("" + p.getFirstName() + " " + p.getLastName());
            }
        }

    }
}
