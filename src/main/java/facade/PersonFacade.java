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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author dennisschmock
 */
public class PersonFacade implements IPersonFacade {

    private static EntityManagerFactory emf;

    public PersonFacade(EntityManagerFactory emf) {
        PersonFacade.emf = emf;
    }

    public PersonFacade() {
    }

    @Override
    public Person getPerson(int id) {
        EntityManager em = this.getEntityManager();
        Person person = null;
        try {
            person = em.find(Person.class, id);
        } finally {
            em.close();
        }

        return person;
    }

    @Override
    public List<Person> getPersons() {
        EntityManager em = this.getEntityManager();
        List<Person> persons = new ArrayList();
        try {
            Query q = em.createQuery("Select p From Person p");
            persons = q.getResultList();
        } finally {
            em.close();
        }
        return persons;
    }

    @Override
    public List<Person> getPersons(int zipCode) {
        EntityManager em = this.getEntityManager();
        List<Person> persons = null;
        try {
            CityInfo ci = em.find(CityInfo.class, zipCode);
            Query q = em.createQuery("Select i FROM InfoEntity i WHERE i.address.cityInfo.zipCode = ?1");
            q.setParameter("1", zipCode);
            persons = q.getResultList();

        } finally {
            em.close();
        }
        return persons;
    }

    @Override
    public List<Person> getPersons(Hobby hobby) {
        EntityManager em = this.getEntityManager();
        List<Person> persons = new ArrayList();
        try {
            Query q = em.createQuery("Select p From Person p WHERE p.hobbies = ?1");
            q.setParameter(1, hobby);
            persons = q.getResultList();
        } finally {
            em.close();
        }
        return persons;
    }

    @Override
    public Person getPerson(Phone phone) {
        EntityManager em = this.getEntityManager();
        Person person;
        try {
            Phone p = em.find(Phone.class, phone);
            Query q = em.createQuery("Select p FROM InfoEntity p WHERE p.phones = ?1");
            q.setParameter(1, p);

            person = (Person) q.getSingleResult();

        } finally {
            em.close();
        }
        return person;
    }

    @Override
    public Person addPhone(Phone phone, Person p) {
        p.addPhone(phone);
        phone.setInfoEntity(p);
        EntityManager em = this.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.merge(phone);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return p;

    }

    @Override
    public Person addHobby(Hobby h, Person p) {
        EntityManager em = this.getEntityManager();
        p.addHobby(h);
        h.addPerson(p);
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.merge(h);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return p;
    }

    @Override
    public List<Person> searchPersons(String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person addPerson(Person person) {
        EntityManager em = this.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return person;
    }

    @Override
    public Person editPerson(Person person) {
        EntityManager em = this.getEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return person;
    }

    @Override
    public Person deletePerson(int id) {
        EntityManager em = this.getEntityManager();
        Person person = null;

        try {
            person = em.find(Person.class, id);
            em.getTransaction().begin();
            em.remove(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return person;
    }

    public Person addAddress(Person p, Address address, int zipcode) {
        EntityManager em = this.getEntityManager();
        CityInfo ci = null;
        try {
            ci = em.find(CityInfo.class, zipcode);
            System.out.println(ci.getZipCode());
            address.addInfoEntity(p);
            address.setCityInfo(ci);
            em.getTransaction().begin();
            em.merge(p);
            em.merge(address);
            em.getTransaction().commit();

        } finally {
            em.close();

        }
        return p;
    };
    
    @Override
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
