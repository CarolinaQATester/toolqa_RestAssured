package com.automacao.auth;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class AuthBasica {
    @Test
    public void AuthenticationBasics()
    {
        RestAssured.baseURI = "https://restapi.demoqa.com/authentication/CheckForAuthentication";
        RequestSpecification request = RestAssured.given();

        Response response = request.get();
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Status message " + response.body().asString());
    }
    @Test
    public void getData() {
        RequestSpecification httpRequest = RestAssured.given();
        Response res = httpRequest.get("https://postman-echo.com/basic-auth");
        ResponseBody body = res.body();
        //Converting the response body to string
        String rbdy = body.asString();
        System.out.println("Data from the GET API- "+rbdy);
    }
    @Test
    public void getData1() {
        RequestSpecification httpRequest = RestAssured.given().auth().basic("postman", "password");
        Response res = httpRequest.get("https://postman-echo.com/basic-auth");
        ResponseBody body = res.body();
        //Converting the response body to string
        String rbdy = body.asString();
        System.out.println("Data from the GET API- "+rbdy);
    }
    @Test
    public void getUserData() {
        //Usando a diretiva preemptiva de autenticação básica para enviar credenciais para o servidor
        RequestSpecification httpRequest = RestAssured.given().auth().preemptive().basic("postman", "password");
        Response res = httpRequest.get("https://postman-echo.com/basic-auth");
        ResponseBody body = res.body();
        //Converting the response body to string
        String rbdy = body.asString();
        System.out.println("Data from the GET API- "+rbdy);
    }
}
