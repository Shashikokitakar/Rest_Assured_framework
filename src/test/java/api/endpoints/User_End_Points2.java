package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class User_End_Points2 {
	
	public static ResourceBundle Get_Url()
	{
		ResourceBundle route=ResourceBundle.getBundle("Route");
		
		return route;
	}
	
	public static Response Create_User(User payload)
	{
		String Post = Get_Url().getString("post_url");
		
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Post);
		
		return response;
		
	}
	
	public static Response read_User(String userName)
	{
		String Get= Get_Url().getString("get_url");
		
		Response response=given()
		.pathParam("username", userName)
		
		.when()
		.get(Get);
		
		return response;
		
	}
	
	public static Response Update_User(String userName, User payload)
	{
		String Put= Get_Url().getString("put_url");
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		
		.when()
		.put(Put);
		
		return response;
		
	}
	
	public static Response delete_User(String userName)
	{
		String Delete= Get_Url().getString("delete_url");
		Response response=given()
		.pathParam("username", userName)
		
		.when()
		.get(Delete);
		
		return response;
		
	}

}

