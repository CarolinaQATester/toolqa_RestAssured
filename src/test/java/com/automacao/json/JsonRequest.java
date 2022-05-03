package com.automacao.json;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.List;

public class JsonRequest {
    @Test
    public void JsonPathUsage() throws MalformedURLException
    {
        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/books/getallbooks";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");

        // Primeiro, obtenha a instância do objeto JsonPath da interface Response
        JsonPath jsonPathEvaluator = response.jsonPath();

        // Leia todos os livros como uma Lista de Strings. Cada item da lista
        // representa um nó de livro no serviço REST Response
        List<Book> allBooks = jsonPathEvaluator.getList("books", Book.class);

        // Iterar sobre a lista e imprimir item de livro individual
        // Observe que cada entrada de livro na lista será o objeto Json completo do livro
        for(Book book : allBooks)
        {
            System.out.println("Book: " + book.title);
        }
    }
    @Test
    public void JsonArrayToArray()
    {

        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/books/getallbooks";
        RequestSpecification request = RestAssured.given();

        Response response = request.get();
        System.out.println("Response Body -> " + response.body().asString());

        // Podemos converter o Json Response diretamente em um Java Array usando
        // Método JsonPath.getObject. Aqui temos que especificar que queremos
        // desserializa o Json em um Array of Book. Isso pode ser feito especificando
        // Book[].class como segundo argumento para o método getObject.
        Book[] books = response.jsonPath().getObject("books",Book[].class );

        for(Book book : books)
        {
            System.out.println("Book title " + book.title);
        }
    }
}
