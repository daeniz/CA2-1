/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Address;
import entity.CityInfo;
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

    private static EntityManagerFactory emf;

    public CompanyFacade(EntityManagerFactory emf) {
        CompanyFacade.emf = emf;
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
            CityInfo ci = em.find(CityInfo.class, zipcode);
            Query q = em.createQuery("Select i FROM InfoEntity i WHERE i.address.cityInfo.zipCode = ?1");
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
            Query q = em.createQuery("Select c FROM Company c where c.numEmployees > ?1");
            q.setParameter("1", employees);
            companies = q.getResultList();

        } finally {
            em.close();
        }
        return companies;

    }

    @Override
    public Company getCompany(Phone phone) {
        EntityManager em = this.getEntityManager();
        Company company = null;
        try {
            Query q = em.createQuery("Select p FROM InfoEntity p WHERE p.phones = ?1");
            q.setParameter(1, phone);

            company = (Company) q.getSingleResult();
        } finally {
            em.close();
        }
        return company;
    }

    @Override
    public Company createCompany(Company company) {
        EntityManager em = this.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(company);
            em.getTransaction().commit();

        } finally {
            em.close();

        }
        return company;
    }

    @Override
    public Company editCompany(Company company) {
        EntityManager em = this.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(company);
            em.getTransaction().commit();

        } finally {
            em.close();

        }
        return company;
    }

    @Override
    public Company deleteCompany(int id) {
        EntityManager em = this.getEntityManager();
        Company co = null;
        try {
            co = em.find(Company.class, id);
            em.getTransaction().begin();
            em.remove(co);
            em.getTransaction().commit();

        } finally {
            em.close();

        }
        return co;
    }

    public Company addAddress(Company co, Address address, int zipcode) {
        EntityManager em = this.getEntityManager();
        CityInfo ci = null;
        try {
            ci = em.find(CityInfo.class, zipcode);
            address.addInfoEntity(co);
            address.setCityInfo(ci);
            em.getTransaction().begin();
            em.merge(ci);
            em.merge(co);
            em.merge(address);
            em.getTransaction().commit();

        } finally {
            em.close();

        }
        return co;
    };

    @Override
    public List<Company> searchCompanies(String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
