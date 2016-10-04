/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Address;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author dennisschmock
 */
public interface IPersonFacade {
    
    public EntityManager getEntityManager();

    public Person getPerson(int id);

    public List<Person> getPersons();

    public List<Person> getPersons(int zipCode);

    public List<Person> getPersons(Hobby hobby);
    
    public Person getPerson(Phone phone);
    
    public Person addPhone(Phone phone, Person p);
    
    public Person addHobby(Hobby h, Person p);
        
    public List<Person> searchPersons(String search);    
    
    public Person addPerson(Person person);
    
    public Person editPerson(Person person);
    
    public Person deletePerson(int id);
    
    public Person addAddress(Person p, Address address, int zipcode);
    
    
    
    
    
    
    
    
}
