package com.automacao.corpoJson;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RestAssuredApiTest {
    @Test
    public void WeatherMessageBody()
    {
        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");

        // Recupera o corpo da resposta
        ResponseBody body = response.getBody();

        // Usando o método ResponseBody.asString(), podemos converter o corpo // na representação de string.
        System.out.println("Response Body is: " + body.asString());
    }
    @Test
    //devo validar o corpo da resposta contém alguma string
    public void WeatherMessageBody1()
    {
        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");

        // Recupera o corpo da resposta
        ResponseBody body = response.getBody();

        // Usando o método ResponseBody.asString(), podemos converter o corpo
        // na representação de string.
        // Para verificar a presença de substring, obtenha o corpo da resposta como uma String.
        System.out.println("Response Body is: " + body.asString());
        // Faz uma String.contains
        String bodyAsString = body.asString();
        assertEquals(bodyAsString.contains("Hyderabad") + "/*Expected value*/", true + "/*Actual Value*/", "Response body contains Hyderabad");

    }
    @Test
    //Verifique a presença de String ignorando maiúsculas e minúsculas
    public void WeatherMessageBody2()
    {
        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");

        // Retrieve the body of the Response
        ResponseBody body = response.getBody();

        // To check for sub string presence get the Response body as a String.
        // Do a String.contains
        String bodyAsString = body.asString();

        // convert the body into lower case and then do a comparison to ignore casing.
        assertEquals(bodyAsString.toLowerCase().contains("hyderabad") +"/*Expected value*/", true + "/*Actual Value*/", "Response body contains Hyderabad");
    }
    @Test
    //devo extrair um texto de nó da resposta usando JsonPath
    public void VerifyCityInJsonResponse()
    {
        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");

        // Primeiro, obtenha a instância do objeto JsonPath da interface Response
        JsonPath jsonPathEvaluator = response.jsonPath();

        // Em seguida, basta consultar o objeto JsonPath para obter um valor String do nó
        // especificado por JsonPath: City (Nota: Você não deve colocar $. no código Java)
        String city = jsonPathEvaluator.get("City");

        // Vamos imprimir a variável city para ver o que temos
        System.out.println("City received from Response " + city);

        // Valida a resposta
        assertEquals(city, "Hyderabad", "Correct city name received in the Response");

    }
    @Test
    //Código de exemplo para ler todos os nós da Weather API Response
    public void DisplayAllNodesInWeatherAPI()
    {
        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");

        // Primeiro, obtenha a instância do objeto JsonPath da interface Response
        JsonPath jsonPathEvaluator = response.jsonPath();

        // Vamos imprimir a variável city para ver o que temos
        System.out.println("City received from Response " + jsonPathEvaluator.get("City"));

        /// Imprime o nó de temperatura
        System.out.println("Temperature received from Response " + jsonPathEvaluator.get("Temperature"));

        // Imprime o nó de umidade
        System.out.println("Humidity received from Response " + jsonPathEvaluator.get("Humidity"));

        // Imprime a descrição do tempo
        System.out.println("Weather description received from Response " + jsonPathEvaluator.get("Weather"));

        // Imprime a velocidade do vento
        System.out.println("City received from Response " + jsonPathEvaluator.get("WindSpeed"));

        // Imprime o grau de direção do vento
        System.out.println("City received from Response " + jsonPathEvaluator.get("WindDirectionDegree"));
    }
}
