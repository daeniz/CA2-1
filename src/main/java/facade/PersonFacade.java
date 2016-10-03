/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> getPersons(Hobby hobby) {
        EntityManager em = this.getEntityManager();
        List<Person> persons = new ArrayList();
        try {
            Query q = em.createQuery("Select p From Person p WHERE p.hobbies = :1");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person addHobby(Hobby h, Person p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> searchPersons(String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person addPerson(Person person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person editPerson(Person person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person deletePerson(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
