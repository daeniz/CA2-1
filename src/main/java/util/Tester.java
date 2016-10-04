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
        Persistence.generateSchema("PU", null);
        IPersonFacade facade = new PersonFacade(Persistence.createEntityManagerFactory("PU"));
        List<Person> persons = new ArrayList();
        System.out.println("persons length "+persons.size());
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        List<CityInfo> ci = new ArrayList();
        try {
            Query q = em.createQuery("SELECT c From CityInfo AS c");
            ci = q.getResultList();
        } finally {
            
        }
        System.out.println("cityinfo size: "+ci.size());
        
        try {
            Query q = em.createQuery("SELECT c FROM Hobby AS c");
            persons = q.getResultList();
        } finally {
            em.close();
        }
        System.out.println("persons length after query: "+persons.size());
        
        
        
        List<Person> persons1 = facade.getPersons(100);
        System.out.println("persons1: "+persons1.size());
        
        
    }
}
