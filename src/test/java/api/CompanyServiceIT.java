/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import entity.Company;
import facade.CompanyFacade;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import static io.restassured.path.json.JsonPath.from;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.hamcrest.Matchers.*;
import org.junit.Ignore;

/**
 *
 * @author Dennis
 */
public class CompanyServiceIT {

    public static Response response;
    public static String jsonAsString;
    public int numberOfCompanies;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    public CompanyFacade cf = new CompanyFacade(emf);
    private Gson gson = new Gson();
    private int testCompanyId;
    Company testCompany;

    public CompanyServiceIT() {
    }

    @BeforeClass
    public static void setUpClass() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8085;
        RestAssured.basePath = "/CA2/api/company/";
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testCompany = new Company("Hejsa", "Hejsa", 111, 111, 111);
        testCompany = cf.createCompany(testCompany);
        testCompanyId = testCompany.getId();
        numberOfCompanies = cf.getCompanies().size();

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllCompanies method, of class CompanyService.
     */
    @Test
    public void testGetAllCompanies() {
        response = given().when().
                get("complete").then().
                contentType(ContentType.JSON).
                extract().response();

        jsonAsString = response.asString();

        ArrayList<Map<String, ?>> jsonAsArrayList = from(jsonAsString).get("");
        assertThat(jsonAsArrayList.size(), equalTo(numberOfCompanies));
    }

    /**
     * Test of getCompanyComplete method, of class CompanyService.
     */
    @Test
    public void testGetCompanyComplete() {
        given().pathParam("id", testCompanyId).when().get("complete/{id}").then().
                statusCode(200).body("name", equalTo(testCompany.getName()));

    }
    
    /**
     * Test of getCompanyComplete method, of class CompanyService.
     */
    @Test
    public void testGetCompanyCompleteWrongArg() {
        given().pathParam("id", "aa").when().get("complete/{id}").then().
                statusCode(404);

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
        Company c1 = new Company("It2Learn", "Really cool", 992233, 10000, 10000);
        String json = gson.toJson(c1);
        Response r = given().contentType("application/json").body(json).when().post();
        int id = r.path("id");

        String body = r.getBody().asString();
        System.out.println("Response: " + body);
        assertThat(id, is(notNullValue()));
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
