/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author danie
 */
@Entity
@DiscriminatorValue (value = "P")
public class Person extends InfoEntity implements Serializable {

//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
    @ManyToMany (cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Hobby> hobbies = new ArrayList();
    private String firstName;
    private String lastName;
    
    public Person(){
        
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    

   
   

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }
 /**
 * adds a hobby to the Person as well as adding this Person to the Hobby!
 *
 * @param  hobby the hobby to be added to the Person
 */
    public void addHobby(Hobby hobby) {
        this.hobbies.add(hobby);
        hobby.getPersons().add(this);      //Thoughts on this approach?
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
