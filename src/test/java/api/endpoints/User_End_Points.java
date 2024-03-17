package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// this class is created to perform create,read, update and delete request
public class User_End_Points {
	
	public static Response Create_User(User payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.post_url);
		
		return response;
		
	}
	
	public static Response read_User(String userName)
	{
		Response response=given()
		.pathParam("username", userName)
		
		.when()
		.get(Routes.get_url);
		
		return response;
		
	}
	
	public static Response Update_User(String userName, User payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		
		.when()
		.put(Routes.put_url);
		
		return response;
		
	}
	
	public static Response delete_User(String userName)
	{
		Response response=given()
		.pathParam("username", userName)
		
		.when()
		.get(Routes.delete_url);
		
		return response;
		
	}

}
