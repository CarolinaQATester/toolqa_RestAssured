package com.automacao.post;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PostRequest {


    /**
     * @Test
     * public void UserRegistrationSuccessful() {
     *         RestAssured.baseURI ="https://demoqa.com";
     *         RequestSpecification request = RestAssured.given();
     *         JSONObject requestParams = new JSONObject();
     *         requestParams.put("UserName", "test_rest");
     *         requestParams.put("Password", "rest@123");
     *         request.body(requestParams.toJSONString());
     *         Response response = request.post("/Account/v1/User");
     *         ResponseBody body = response.getBody();
     *         System.out.println(response.body().asString());
     *         if(response.statusCode() == 200) {
     *
     * // Deserialize the Response body into JSONFailureResponse
     *             JSONFailureResponse responseBody = body.as(JSONFailureResponse.class);
     *
     * // Use the JSONFailureResponse class instance to Assert the values of Response.
     *             Assert.assertEquals("User already exists", responseBody.FaultId);
     *             Assert.assertEquals("FAULT_USER_ALREADY_EXISTS", responseBody.fault);
     *         } else if (response.statusCode() == 201) {
     *
     * // Deserialize the Response body into JSONSuccessResponse
     *             JSONSuccessResponse responseBody = body.as(JSONSuccessResponse.class);
     *
     * // Use the JSONSuccessResponse class instance to Assert the values of response.
     *             Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
     *             Assert.assertEquals("Operation completed successfully", responseBody.Message);
     *         }
     *     }*/


}
