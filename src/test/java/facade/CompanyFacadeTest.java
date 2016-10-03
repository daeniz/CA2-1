/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Company;
import entity.Person;
import entity.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danie
 */
public class CompanyFacadeTest {
    static EntityManagerFactory emf= Persistence.createEntityManagerFactory("pu_test");
    private static ICompanyFacade facade = new CompanyFacade(Persistence.createEntityManagerFactory("pu_test"));
    
    public CompanyFacadeTest() {
        
    }
    
    @Before
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.createQuery("delete from Person").executeUpdate(); //Ehm... Somthing is not working
//            Person p1= new Person("aa","bb","123");
//            Person p2= new Person("cc","dd","123");
//            em.persist(p1);
//            em.persist(p2);
            em.getTransaction().commit();
        }
        finally{
            em.close();
        }
    }


    @Test
    public void testGetCompany() {
        System.out.println("getCompany");
        int id = 0;
        CompanyFacade instance = null;
        Company expResult = null;
        Company result = instance.getCompany(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCompanies_0args() {
        System.out.println("getCompanies");
        CompanyFacade instance = null;
        List<Company> expResult = null;
        List<Company> result = instance.getCompanies();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCompanies_int() {
        System.out.println("getCompanies");
        int zipcode = 0;
        CompanyFacade instance = null;
        List<Company> expResult = null;
        List<Company> result = instance.getCompanies(zipcode);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
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
