/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityTester;

import entity.Address;
import entity.Company;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import facade.CompanyFacade;
import facade.ICompanyFacade;
import facade.IPersonFacade;
import facade.PersonFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import util.JSONConverter;

/**
 *
 * @author danie
 */
public class Tester {

    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("PU");
    private static final IPersonFacade PF = new PersonFacade(EMF);
    private static final ICompanyFacade CF = new CompanyFacade(EMF);
    private static JSONConverter jc = new JSONConverter();

    public static void main(String[] args) {
        Persistence.generateSchema("PU", null);

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


        c1 = CF.addAddress(c1, a1, 2600);
        
        System.out.println("LIST COMPANIES");
        List<Company> cs = CF.getCompanies();
        for (Company c : cs) {
            System.out.println(c);
        }

        List<Company> companies = CF.getCompanyMinEmp(1200);
        for (Company company : companies) {
            System.out.println(company.getName());
        }

        List<Company> companiesZip = CF.getCompanies(2600);

        System.out.println("Size is: " + companiesZip.size());
        for (Company company : companiesZip) {
            System.out.println(company.getName());
        }

        //Testing Personfacade
        Person p1 = new Person("Dennis", "Schmock");
        Person p2 = new Person("1Dennis", "Schmock");
        Person p3 = new Person("2Dennis", "Schmock");
        Person p4 = new Person("3Dennis", "Schmock");
        Address a2 = new Address("Nørgade", "Somewhere nice");
        Phone phone1 = new Phone(11554455, "Home");
        Hobby hobby = new Hobby("Golf", "Boring sport with big clubs and small balls.");
        
        p1.addHobby(hobby);
        p1.addPhone(phone1);
        p1.setAddress(a2);
        
        
        PF.addPerson(p1);
        PF.addPerson(p2);
        PF.addPerson(p3);
        PF.addPerson(p4);
        
        PF.addAddress(p1, a2, 2600);
        List<Phone> phones =  c1.getPhones();
        for (Phone phone2 : phones) {
            System.out.println(phone2.getNumber());
        }
        
        System.out.println(jc.companyJson(c1));
        System.out.println(cs);
        
        

    }
}
