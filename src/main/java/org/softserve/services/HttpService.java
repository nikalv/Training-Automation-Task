package org.softserve.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HttpService {

    static public Response sendUser(String userJSONInString){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(userJSONInString);
        Response response = request.post("https://jsonplaceholder.typicode.com/users");
        return response;
    }

    static public Response updateUser(String userJSONInString, int id){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(userJSONInString);
        request.pathParam("id", id);
        Response response = request.put("https://jsonplaceholder.typicode.com/users/{id}");
        return response;
    }

    static public Response getUserById(int id){
        RequestSpecification request = RestAssured.given();
        request.pathParam("id", id);
        Response response = request.get("https://jsonplaceholder.typicode.com/users/{id}");
        return response;
    }

    static public Response getUsers(){
        RequestSpecification request = RestAssured.given();
        Response response = request.get("https://jsonplaceholder.typicode.com/users");
        return response;
    }

    //TODO: check where request header is needed
}
