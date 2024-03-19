package api.endpoints;
import api.payload.Store;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Store_Endpoints {
	
	public static Response Create_request(Store payload)
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.body(payload)
		
		.when()
			.post(Routes_store.post_url);
		return response; 
	}
	
	public static Response Read_request(int id)
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.pathParam("orderId", id)
		
		.when()
			.post(Routes_store.get_url);
		return response; 
	}
	
	public static Response Delete_request(int id)
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.pathParam("orderId", id)
		
		.when()
			.post(Routes_store.get_url);
		return response; 
	}

}
