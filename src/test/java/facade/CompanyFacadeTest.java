/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Address;
import entity.CityInfo;
import entity.Company;
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
import org.junit.Ignore;

/**
 *
 * @author danie
 */
public class CompanyFacadeTest {
    static EntityManagerFactory emf= Persistence.createEntityManagerFactory("pu_test");
    private static ICompanyFacade facade;
    
    Company c1;
    Company c2;
    Company c3;
    Hobby h1;
    CityInfo ci1;
            
            
    public CompanyFacadeTest() {
        
    }
    
    @Before
    public void setUp() {
        facade= new CompanyFacade(Persistence.createEntityManagerFactory("pu_test"));
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.createQuery("delete from Company").executeUpdate(); 
            em.createQuery("delete from Phone").executeUpdate();
            em.createQuery("delete from Address").executeUpdate();
            em.createQuery("delete from Hobby").executeUpdate();
            
            
            
            Person p1= new Person("Bob","Marley");
            c1 = new Company("CPH-Business", "School", 01234,200,200000); //String name, String description, int cvr, int numEmployees, int marketValue
            c2 = new Company("Vaskeriet", "School Building", 01235,200,200000);
            c3 = new Company("CPH-Business", "School", 01236,200,200000);
            h1 = new Hobby("Jammin'","Playing Dirty Hippie-music");
            ci1 = new CityInfo(2800,"Lyngby");
            Address a1 = new Address("Nørgaardsvej","30",ci1);
            Address a2 = new Address("Nørgaardsvej","30",ci1);
            Phone ph1 = new Phone(11223344);
            c1.addPhone(ph1);
            c1.setAddress(a1);
            a1.setCityInfo(ci1);
            
            
            p1.setAddress(a1);
            p1.addHobby(h1);
            

            //em.persist(p1);
            em.persist(c1);
            em.persist(a1);
            em.persist(ci1);
            em.persist(ph1);
            em.getTransaction().commit();
        }
        finally{
            em.close();
        }
    }


    @Test
    public void testGetCompany() {
        System.out.println("getCompany");
        int id = 1;
        
        Company expResult = c1;
        Company result = facade.getCompany(id);
        assertEquals(expResult, result);
    }

    @Test
    @Ignore
    public void testGetCompanies() {
        System.out.println("getCompanies");
        List<Company> expResult = null;
        List<Company> result = facade.getCompanies();
        assertEquals(expResult, result);
    }

    @Test
    @Ignore
    public void testGetCompaniesFromZip() {
        System.out.println("getCompanies");
        int zipcode = 2800;
        CompanyFacade instance = null;
        List<Company> expResult = null;
        int expSize = 2;
        List<Company> result = facade.getCompanies(zipcode);
        assertEquals(expResult, result);
    }

    @Test
    @Ignore
    public void testGetCompanyMinEmp() {
        System.out.println("getCompanyMinEmp");
        int employees = 0;
        CompanyFacade instance = null;
        List<Company> expResult = null;
        List<Company> result = instance.getCompanyMinEmp(employees);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

//    @Test
//    public void testGetCompanies_Phone() {
//        System.out.println("getCompanies");
//        Phone phone = null;
//        CompanyFacade instance = null;
//        Company expResult = null;
//        Company result = instance.getCompanies(phone);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

    @Test
    @Ignore
    public void testSearchCompanies() {
        System.out.println("searchCompanies");
        String search = "";
        CompanyFacade instance = null;
        List<Company> expResult = null;
        List<Company> result = instance.searchCompanies(search);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    @Ignore
    public void testCreateCompany() {
        System.out.println("createCompany");
        Company company = null;
        CompanyFacade instance = null;
        Company expResult = null;
        Company result = instance.createCompany(company);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    @Ignore
    public void testEditCompany() {
        System.out.println("editCompany");
        Company company = null;
        CompanyFacade instance = null;
        Company expResult = null;
        Company result = instance.editCompany(company);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    @Ignore
    public void testDeleteCompany() {
        System.out.println("deleteCompany");
        int id = 0;
        CompanyFacade instance = null;
        Company expResult = null;
        Company result = instance.deleteCompany(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
