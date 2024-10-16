package tests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Map;

public class PetStore {

    public Response createPet(String payload){
        Response response = RestAssured.given().body(payload).contentType("application/json").post("https://petstore.swagger.io/v2/pet").thenReturn();
        System.out.println(response.statusCode());
        System.out.println(response.body().asString());
        return response;
    }

    public static void main(String[] args){
        Response response = new PetStore().createPet("{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}");
        String response_str = response.body().asString();
        System.out.println("DOne");
        JsonPath.from(response_str).getList("tags").get(0);
        JsonPath.from(response_str).getList("tags", Map.class);
    }

    public void tryAuth(){

    }

}
