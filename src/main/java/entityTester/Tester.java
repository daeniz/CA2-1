/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityTester;

import entity.Address;
import entity.Company;
import entity.Person;
import entity.Phone;
import facade.CompanyFacade;
import facade.ICompanyFacade;
import facade.IPersonFacade;
import facade.PersonFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author danie
 */
public class Tester {

    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("PU");
    private static final IPersonFacade PF = new PersonFacade(EMF);
    private static final ICompanyFacade CF = new CompanyFacade(EMF);

    public static void main(String[] args) {
        Persistence.generateSchema("PU", null);

        Person p1 = new Person("Dennis", "Schmock");
        Person p2 = new Person("1Dennis", "Schmock");
        Person p3 = new Person("2Dennis", "Schmock");
        Person p4 = new Person("3Dennis", "Schmock");

        Company c1 = new Company("My company", "Nice", 1111, 1111, 1111);
        Company c2 = new Company("1My company", "Nice", 1111, 1111, 1111);
        Company c3 = new Company("2My company", "Nice", 1111, 1111, 1111);
        Company c4 = new Company("3My company", "Nice", 1111, 1111, 1111);

        Address a1 = new Address("Nørgade", "Somewhere nice");
        Phone phone = new Phone(11554455, "Home");
        c1.addPhone(phone);

        CF.createCompany(c1);
        CF.createCompany(c2);
        CF.createCompany(c3);
        CF.createCompany(c4);

        c1.setEmail("Dennis@schmock.eu");
        phone.setInfoEntity(c1);

        CF.editCompany(c1);
        System.out.println(phone.getId());

        CF.deleteCompany(c4.getId());
        
        CF.addAddress(c1, a1, 2600);
        
        List<Company> cs = CF.getCompanies();
        for (Company c : cs) {
            System.out.println(c.getName());
        }
        
        List<Company> companies = CF.getCompanyMinEmp(1200);
        for (Company company : companies) {
            System.out.println(company.getName());   
        }
        
         List<Company> companiesZip =  CF.getCompanies(2600);
         for (Company company : companiesZip) {
             System.out.println(company.getName());
        }

        

        System.out.println(c1.getAddress().getCityInfo().getCity());
        // System.out.println(CF.getCompany(phone));
        // PF.addPerson(p1);
    }
}
