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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    Person p1;
    Person p2;
    Person p3;
    Company c1;
    Company c2;
    Company c3;
    Hobby h1;
    Hobby h2;
    Hobby h3;
    CityInfo ci1;
    CityInfo ci2;
    CityInfo ci3;
    Address a1;
    Address a2;
    Address a3;
    Phone ph1;
    Phone ph2;
    Phone ph3;
    Phone ph4;
    Phone ph5;
    Phone ph6;
            
            
    public CompanyFacadeTest() {
        
    }
    
    @Before
    @Ignore
    public void setUp() {
        facade= new CompanyFacade(Persistence.createEntityManagerFactory("pu_test"));
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.createQuery("delete from Company").executeUpdate(); 
            em.createQuery("delete from Phone").executeUpdate();
            em.createQuery("delete from Address").executeUpdate();
            em.createQuery("delete from Hobby").executeUpdate();
            em.createQuery("delete from CityInfo").executeUpdate();
            em.createQuery("delete from Person").executeUpdate();
            
            
            p1= new Person("Bob","Marley");
            p2= new Person("John","Green");
            p3= new Person("James","Brown");
            c1 = new Company("CPH-Business", "School", 01234,200,200000); //String name, String description, int cvr, int numEmployees, int marketValue
            c2 = new Company("Vaskeriet", "School Building", 01235,200,200000);
            c3 = new Company("Zoo", "Animal storage", 01236,720,7600000);
            h1 = new Hobby("Jammin'","Playing Dirty Hippie-music");
            h2 = new Hobby("Dancing","Erotic temptation");
            h3 = new Hobby("Fishing","Using nets and stuff");
            ci1 = new CityInfo(2800,"Lyngby");
            ci2 = new CityInfo(2670,"Greve");
            ci3 = new CityInfo(2000,"Frederiksberg");
            a1 = new Address("Nørgaardsvej","30",ci1);
            a2 = new Address("Gl Kongevej","22b",ci3);
            a3 = new Address("Strandvejen","245, 1.tv",ci2);
            ph1 = new Phone(11223344);
            ph2 = new Phone(22334455);
            ph3 = new Phone(33445566);
         //   System.out.println("Get adress: " + a1.getCityInfo().getZipCode());
            
            c1.addPhone(ph1);
            c1.setAddress(a1);
            //a1.setCityInfo(ci1);
            
            
            p1.setAddress(a1);
            p1.addHobby(h1);
            p1.addPhone(ph4);
            
            p2.setAddress(a1);
            p2.addHobby(h2);
            p2.addPhone(ph5);
            
            p3.setAddress(a2);
            p3.addHobby(h1);
            p3.addHobby(h2);
            p3.addHobby(h3);
            p3.addPhone(ph6);
            

            //em.persist(p1);
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.persist(a1);
            em.persist(a2);
            em.persist(a3);
            em.persist(ci1);
            em.persist(ci2);
            em.persist(ci3);
            em.getTransaction().commit();
            
                    System.out.println(c1.getAddress().getCityInfo().getZipCode());

        }
        finally{
            em.close();
        }
    }


    @Test
    public void testGetCompany() {
        System.out.println("getCompany");
        int id = c1.getId();
        
        Company expResult = c1;
        Company result = facade.getCompany(id);
        assertEquals(expResult, result);
        
    }

    @Test
    public void testGetCompanies() {
        System.out.println("getCompanies");
        List<Company> expResult = null;
        int expSize = 3;
        List<Company> result = facade.getCompanies();
        assertEquals(expSize, result.size());
    }

    @Test
    public void testGetCompaniesFromZip() {
        System.out.println("getCompanies");
        int zipcode = 2800;
        List<Company> expResult = null;
        int expSize = 1;
        List<Company> result = facade.getCompanies(zipcode);
        assertEquals(expSize, result.size());
    }

    @Test
    public void testGetCompanyMinEmp() {
        
        System.out.println("getCompanyMinEmp");
        
        int employees = 199;
        List<Company> expResult = null;
        List<Company> result = facade.getCompanyMinEmp(employees);
        assertEquals(3, result.size());
        employees = 200;
        result = facade.getCompanyMinEmp(employees);
        assertEquals(1, result.size());
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
        String search = "re";
        CompanyFacade instance = null;
        List<Company> expResult = null;
        List<Company> result = facade.searchCompanies(search);
        assertEquals(2, result.size());
    }

    @Test
    public void testCreateCompany() {
        System.out.println("createCompany");
        Company company = new Company("Mcd","Greasy Fastfood",12347,1350,79612265);
        Company result = facade.createCompany(company);
        assertEquals(company, result);
    }

    @Test
    public void testEditCompany() {
        System.out.println("editCompany");
        Company company = facade.getCompany(c1.getId());
        company.setName("Mcd");
        company.setDescription("Greasy Fastfood");
        company.setCvr(12347);
        company.setNumEmployees(1350);
        Company result = facade.editCompany(company);
        assertEquals("Mcd", result.getName());
        assertEquals("Greasy Fastfood", result.getDescription());
        assertEquals(12347, result.getCvr());
        assertEquals(1350, result.getNumEmployees());
        
        result = facade.getCompany(c1.getId());
        assertEquals("Mcd", result.getName());
        assertEquals("Greasy Fastfood", result.getDescription());
        assertEquals(12347, result.getCvr());
        assertEquals(1350, result.getNumEmployees());
    }

    @Test
    public void testDeleteCompany() {
       
        System.out.println("deleteCompany");
        int id = c2.getId();
        Company expResult = facade.getCompany(id);
        
        Company result = facade.deleteCompany(id);
        assertEquals(expResult, result);
        result = facade.getCompany(id);
        assertTrue(result==null);
        
        
    }
    
}
