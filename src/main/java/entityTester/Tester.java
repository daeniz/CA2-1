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
               

    }
}
