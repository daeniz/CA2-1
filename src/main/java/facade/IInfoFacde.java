/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

/**
 *
 * @author dennisschmock
 */
public interface IInfoFacde {
    Person getPerson(int id);
    List<Person> getPersons();
    List<Person> getPersons(int zipCode);
    Company getCompany(cvr);
    Person getPerson(Hobby hobby);
    
    
    
}
