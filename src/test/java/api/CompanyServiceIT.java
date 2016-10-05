/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;
import static org.hamcrest.Matchers.*;
import org.junit.Ignore;

/**
 *
 * @author Dennis
 */
public class CompanyServiceIT {

    public CompanyServiceIT() {
    }

    @BeforeClass
    public static void setUpClass() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 7070;
        RestAssured.basePath = "CA2/api/company";
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllCompanies method, of class CompanyService.
     */
    @Test
    public void testGetAllCompanies() {
    }

    /**
     * Test of getCompanyComplete method, of class CompanyService.
     */
    @Test
    public void testGetCompanyComplete() {
    }

    /**
     * Test of getCompaniesContactInfo method, of class CompanyService.
     */
    @Test
    public void testGetCompaniesContactInfo_0args() {
    }

    /**
     * Test of getCompaniesContactInfo method, of class CompanyService.
     */
    @Test
    public void testGetCompaniesContactInfo_int() {
    }

    /**
     * Test of getCompaniesInACity method, of class CompanyService.
     */
    @Test
    public void testGetCompaniesInACity() {
    }

    /**
     * Test of createCompany method, of class CompanyService.
     */
    @Test
    public void testCreateCompany() {
    }

    /**
     * Test of editCompany method, of class CompanyService.
     */
    @Test
    public void testEditCompany() {
    }

    /**
     * Test of deleteCompany method, of class CompanyService.
     */
    @Test
    public void testDeleteCompany() {
    }

    @Test
    public void serverIsRunning() {
        System.out.println("Server is running:");
        given().when().get().then().statusCode(200);
    }
}
