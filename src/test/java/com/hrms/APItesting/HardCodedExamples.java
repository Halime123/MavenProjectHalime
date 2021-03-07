package com.hrms.APItesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.testng.Assert;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matcher.*;

import static io.restassured.RestAssured.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardCodedExamples {
    //given()
    //when()
    //then()

    String baseURI=RestAssured.baseURI = "http://3.237.189.167/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MTQ4MDI0ODYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYxNDg0NTY4NiwidXNlcklkIjoiMjI5MCJ9.G9e7SaXCxqUrZMKzND25tIVinsFGCJt1J8co8qGtbDY";
   static String employeeID;

    @Test
    public void sampleTest() {
        /**
         * BaseURI for all endpoints
         */
       // RestAssured.baseURI = "http://3.237.189.167/syntaxapi/api";
        //String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MTQ4MDI0ODYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYxNDg0NTY4NiwidXNlcklkIjoiMjI5MCJ9.G9e7SaXCxqUrZMKzND25tIVinsFGCJt1J8co8qGtbDY";
        //presparing request to get one employee
        RequestSpecification preparingGetOneEmployeeRequest = given().header("Authorization", token)
                .header("Content-Type", "Application/json")
                .queryParam("employee_id", "3695");
        //sending the request to the endpoint
        Response getOneEmployeeResponse = preparingGetOneEmployeeRequest.when().get("/getOneEmployee.php");
        //print the response
        System.out.println(getOneEmployeeResponse.asString());

        getOneEmployeeResponse.prettyPrint();

        getOneEmployeeResponse.then().assertThat().statusCode(200);
    }
    @Test
    public void aPostCreateEmployee(){
        /**
         * prepareing request for creating an employee
         */
        RequestSpecification createEmployeeRequest=given().header ("Authorization",token).header("Content-Type","application/json").body("{\n" +
                "  \"emp_firstname\": \"string\",\n" +
                "  \"emp_lastname\": \"string\",\n" +
                "  \"emp_middle_name\": \"string\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"2021-03-03\",\n" +
                "  \"emp_status\": \"string\",\n" +
                "  \"emp_job_title\": \"string\"\n" +
                "}");
        /**
         * making to call/createEmployee.php
         */
        Response createEmployeeResponse=createEmployeeRequest.when().log().all().post("/createEmployee.php");
        /**
         * creating response
         */

        createEmployeeResponse.prettyPrint();

        employeeID=createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
        /**
         * optional:printing employeeID
         */
        System.out.println(employeeID);
        /**
         * verifying static code is 201
         */
        createEmployeeResponse.then().assertThat().statusCode(201);
        /**
         * verifying response body "Message is paired with "Entry created"
         */
        createEmployeeResponse.then().assertThat().body("Message",equalTo("Entry Created"));

        createEmployeeResponse.then().assertThat().body("Employee[0]",equalTo("syntaxFirstName"));

        createEmployeeResponse.then().header("Server","Apache/2.4.39");
}

    @Test
    public void bGetcreateEmployee(){
        RequestSpecification getCreateEmployee=given().header("Content-Type","application/json").header("Authorization",token)
                .queryParam("employee_id",employeeID);
        Response getCreatedEmployeeResponse=getCreateEmployee.when().get("/getOneEmployee.php");
        getCreatedEmployeeResponse.prettyPrint();
        String empID=getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
        boolean verifyingEmployeeID=empID.equalsIgnoreCase(employeeID);
        Assert.assertTrue(verifyingEmployeeID);

        /**
         *
         */
        getCreatedEmployeeResponse.then().assertThat().statusCode(200);
        String response=getCreatedEmployeeResponse.asString();
        JsonPath js=new JsonPath(response);

        String employeeid=js.getString("employee[0].employee_id");
        String firstName=js.getString("employee[0].emp_firstname");


        Assert.assertTrue(employeeid.contentEquals(employeeID));

        Assert.assertEquals(firstName,"SyntaxFirstName");






    }
    @Test
    public void cGetAllEmployees(){
        RequestSpecification getAllEmployeeRequest=given()
                .header("Content-Type","application/json").header("Authorization",token);
        Response getAllEmployeesResponse=getAllEmployeeRequest.when().get("/getAllEmployees.php");
        getAllEmployeesResponse.prettyPrint();
        String response=getAllEmployeesResponse.asString();

        JsonPath js=new JsonPath(response);
        int num=js.getInt("Employee.size()");
        System.out.println(num);

        for(int i=0; i<num;i++){
            String allEmployeeIDs=js.getString("Employees[" +i+"].employee_id");
            System.out.println(allEmployeeIDs);
        }
    }

}