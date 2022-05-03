package com.automacao.delete;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeleteBook {
    String userId= "de5d75d1-59b4-487e-b632-f18bc0665c0d";
    String baseUrl="https://demoqa.com/swagger/";
    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InRlc3RpbmcxMjMiLCJwYXNzd29yZCI6IlBhc3N3b3JkQDEiLCJpYXQiOjE2Mjg1NjQyMjF9.lW8JJvJF7jKebbqPiHOBGtCAus8D9Nv1BK6IoIIMJQ4";
    String isbn ="9781449337711";

    @Before
    @After
    public void getUserData() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest =
                RestAssured.given().header("Authorization", "Bearer " + token)
                        .header("Content-Type", "application/json");

        Response res = httpRequest.get("/Account/v1/User/"+userId);
        ResponseBody body = res.body();
        //Converting the response body to string
        String rbdy = body.asString();
        System.out.println("Data from the GET API- "+rbdy);
    }

    @Test
    public void deleteBook() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        //Chamando a API Delete com o corpo da solicitação
        Response res = httpRequest.body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\"}").delete("/BookStore/v1/Book");

        ///Buscando o código de resposta da requisição e validando o mesmo
        System.out.println("The response code is - " +res.getStatusCode());
        assertEquals(res.getStatusCode(),204);

    }
}
