package com.automacao.primeiroTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class RestAssuredApiTest {

    @Test
    public void GetBooksDetails() {
        // Especifique a URL base para o serviço web RESTful
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        // Obtém a RequestSpecification da solicitação a ser enviada ao servidor.
        RequestSpecification httpRequest = RestAssured.given();
        // especifica o tipo de método (GET) e os parâmetros se houver.
        //Nesse caso a requisição não recebe nenhum parâmetro
        Response resposta = httpRequest.request(Method.GET, "");
        // Imprime o status e o corpo da mensagem da resposta recebida do servidor
        System.out.println("Status recebido => " + resposta.getStatusLine());
        System.out.println("Resposta=>" + resposta.prettyPrint());

    }

    @Test
    public void GetWeatherDetailsCondensed() {
        // Especifique a URL base para o serviço web RESTful
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

        // Obter a RequestSpecification da solicitação que deve ser enviada
        // para o servidor.
        RequestSpecification httpRequest = RestAssured.given();

        // Chame o método RequestSpecification.get() para obter a resposta.
        // Certifique-se de especificar o nome do recurso.
        Response response = httpRequest.get("");

        // O método Response.asString retornará diretamente o conteúdo do corpo
        // Como corda.
        System.out.println("Response Body is =>  " + response.asString());

    }
}