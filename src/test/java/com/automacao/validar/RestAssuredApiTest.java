package com.automacao.validar;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RestAssuredApiTest {
    @Test
    //Obter retorno da ai
    public void GetWeatherDetails() {
        // Especifique a URL base para o serviço web RESTful
        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
        // Obtém a RequestSpecification da solicitação que você deseja enviar
        // para o servidor. O servidor é especificado pelo BaseURI que temos
        // especificado na etapa acima.
        RequestSpecification httpRequest = RestAssured.given();
        // Faça uma chamada de solicitação GET diretamente usando o método RequestSpecification.get().
        // Certifique-se de especificar o nome do recurso.
        Response resposta = httpRequest.get("/Hyderabad");
        // O método Response.asString retornará diretamente o conteúdo do corpo
        // Como corda.
        System.out.println("O corpo da resposta é => " + resposta.asString());
    }

    @Test
    //Validando o código de status da resposta
    public void GetWeatherDetails1() {
        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");

        // Obtém o código de status do Response. No caso de
        // uma interação bem sucedida com o serviço web, nós
        // deve obter um código de status de 200.
        int statusCode = response.getStatusCode();

        // Assert que o código de status correto foi retornado.
        assertEquals(statusCode + "/*actual value*/", 200 + "/*expected value*/", "Correct status code returned");
    }

    @Test
    //Validando o código de status de erro
    public void GetWeatherDetailsInvalidCity() {
        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/78789798798");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode + "/*actual value*/", 200 + "/*expected value*/", "Correct status code returned");
    }

    @Test
    //Validar cabeçalhos
    public void IteratingHeaders() {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
        // Obtém todos os cabeçalhos e depois itera sobre allHeaders para imprimir cada cabeçalho
        Headers allHeaders = response.headers();
        // Iterar sobre todos os cabeçalhos
        for (Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
    }

    @Test
    //Validando a Linha de Status da Resposta
    public void GetWeatherStatusLine() {
        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");

        // Obtém a linha de status da resposta e armazena em uma variável chamada statusLine
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine + "/*actual value*/", "HTTP/1.1 200 OK" + "/*expected value*/", "Correct status code returned");
    }

    @Test
    public void GetBookHeaders() {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
        // Cabeçalho de acesso com um determinado nome.
        String contentType = response.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);
        // Access header with a given name.
        String serverType = response.header("Server");
        System.out.println("Server value: " + serverType);
        // Cabeçalho de acesso com um determinado nome. Cabeçalho = Codificação de Conteúdo
        String acceptLanguage = response.header("Content-Encoding");
        System.out.println("Content-Encoding: " + acceptLanguage);
    }
    @Test
    //Como validar o cabeçalho de resposta HTTP usando o Rest Assured
    public void ValidateBookHeaders() {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
        // Cabeçalho de acesso com um determinado nome. Cabeçalho = Tipo de Conteúdo
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType /* actual value */, "application/json; charset=utf-8" /* expected value */);
        // Cabeçalho de acesso com um determinado nome. Cabeçalho = Servidor
        String serverType = response.header("Server");
        Assert.assertEquals(serverType /* actual value */, "nginx/1.17.10 (Ubuntu)" /* expected value */);
    }

}



