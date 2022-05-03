package com.automacao.put;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PutRequest {

    String userId = "toolsqa_test";
    String baseUrl = "https://demoqa.com";
    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InRlc3RpbmcxMjMiLCJwYXNzd29yZCI6IlBhc3N3b3JkQDEiLCJpYXQiOjE2Mjg1NjQyMjF9.lW8JJvJF7jKebbqPiHOBGtCAus8D9Nv1BK6IoIIMJQ4";
    String isbn = "9781449325865";

    @Test
    public void putMethod() {


        RequestSpecification httpRequest = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
    }
    @Test
    public void updateBook() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        //Calling the Delete API with request body
        Response res = httpRequest.body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\"}")
                .put("/BookStore/v1/Book/9781449325862");

        //Fetching the response code from the request and validating the same
        System.out.println("The response code - " +res.getStatusCode());
        assertEquals(res.getStatusCode(),200);

    }
}
