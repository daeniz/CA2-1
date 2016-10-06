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
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
            Query q = em.createQuery("Select c FROM Company c WHERE c.address.cityInfo.zipCode = ?1");
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
            Query q = em.createQuery("Select c FROM Company c WHERE c.phones = ?1");
            q.setParameter("1", phone);

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
            System.out.println(ci.getZipCode());
            address.addInfoEntity(co);
            address.setCityInfo(ci);
            em.getTransaction().begin();
            em.merge(co);
            em.merge(address);
            em.getTransaction().commit();

        } finally {
            em.close();

        }
        return co;
    }

    ;

    @Override
    public List<Company> searchCompanies(String search) {
        String sql = "SELECT COMPANY.NAME from INFOENTITY right join CA2.COMPANY "
                + "on INFOENTITY.ID = COMPANY.ID right join ADDRESS "
                + "on INFOENTITY.ADDRESS_ID = ADDRESS.ID"
                + "where COMPANY.NAME like '%s%' "
                + "or cast(COMPANY.CVR as char) like '1%'; ";

        EntityManager em = this.getEntityManager();
        List<Company> companies = new ArrayList();
//        try {
//            Query q = em.createNativeQuery(sql, Company.class);
//            companies = q.getResultList();
//        } finally {
//            em.close();
//        }

        return companies;

    }

    @Override
    public List<Company> searchCompany(String search) {
        List<Company> companies;
        System.out.println("SearchCompany");

        EntityManager em = this.getEntityManager();
        Query q;
        try{
            int i = Integer.valueOf(search);
            q = em.createQuery(   "SELECT DISTINCT c FROM Company c LEFT OUTER JOIN c.address a LEFT OUTER JOIN a.cityInfo ci " +
                                    "LEFT OUTER JOIN c.phones p where p.number=?1 or c.cvr=?1");
            q.setParameter("1", i);
            
        }
        catch(Exception e){
            q = em.createQuery(   "SELECT DISTINCT c FROM Company c LEFT OUTER JOIN c.address a LEFT OUTER JOIN a.cityInfo ci " +
                                    "LEFT OUTER JOIN c.phones p where a.street like ?1 or c.name like ?1 or ci.city like ?1");
            q.setParameter("1", "%"+search+"%");
        }
        
        
            
            companies=q.getResultList();
            
            System.out.println(companies.size());


        return companies;
    }

}
