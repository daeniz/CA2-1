/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Company;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author dennisschmock
 */
public class CompanyFacade implements ICompanyFacade {

    public static EntityManagerFactory emf;

    public CompanyFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public Company getCompany(int id) {
        EntityManager em = this.getEntityManager();
        Company company = null;
        try {
            company = em.find(Company.class, id);
        } finally {
            em.close();
        }

        return company;
    }

    @Override
    public List<Company> getCompanies() {
        EntityManager em = this.getEntityManager();
        List<Company> companies = new ArrayList();
        try {
            Query q = em.createQuery("Select c From Company c");
            companies = q.getResultList();
        } finally {
            em.close();
        }
        return companies;

    }

    @Override
    public List<Company> getCompanies(int zipcode) {
        EntityManager em = this.getEntityManager();
        List<Company> companies = null;
        try {
            Query q = em.createQuery("Select c FROM Company c where c.address.cityinfo.zipcode = :1");
            q.setParameter("1", zipcode);
            companies = q.getResultList();

        } finally {
            em.close();
        }
        return companies;
    }

    @Override
    public List<Company> getCompanyMinEmp(int employees) {
        EntityManager em = this.getEntityManager();
        List<Company> companies = null;
        try {
            Query q = em.createQuery("Select c FROM Company c where c.numEmployees > :1");
            q.setParameter("2", employees);
            companies = q.getResultList();

        } finally {
            em.close();
        }
        return companies;

    }

    @Override
    public List<Company> getCompanies(Phone phone) {
        EntityManager em = this.getEntityManager();
        List<Company> companies = null;
        try {
            Query q = em.createQuery("Select c FROM Company c WHERE c.phones as :1");
            q.setParameter("1", phone);
            companies = q.getResultList();

        } finally {
            em.close();
        }
        return companies;
    }

    

    @Override
    public Company createCompany(Company company) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Company editCompany(Company company) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Company deleteCompany(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Company> searchCompanies(String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
