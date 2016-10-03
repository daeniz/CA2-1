/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Company;
import entity.Phone;
import java.util.List;

/**
 *
 * @author dennisschmock
 */
public interface ICompanyFacade {
      
    public Company getCompany(int cvr);
       
      public List<Company> getCompanies();
       public List<Company> getCompanies(int zipcode);
       
       public Company getCompanyMinEmp(int employees);
       
       public <List> Company getCompanies(Phone phone);
       
       public Company createCompany(Company company);
       
       public Company editCompany(Company company);
       
       public Company deleteCompany(int id);
       
       

}
