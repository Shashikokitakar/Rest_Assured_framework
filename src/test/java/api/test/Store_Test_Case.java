package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Store_Endpoints;
import api.payload.Store;
import io.restassured.response.Response;

public class Store_Test_Case
{

	Faker fake;
	Store data;
	@BeforeClass
	public void SetUp()
	{
		data= new Store();
		fake=new Faker();
		data.setId(5);
		data.setPetid(0);
		data.setQuantity(3);
		data.setShipdate("2024-03-19T04:59:25.013Z");
		data.setStatus("placed");
		data.setComplete("true");
		
	}
	@Test(priority=1)
	public void create_user()
	{
		Response response=Store_Endpoints.Create_request(data);
			response.then().statusCode(200).log().all();
	}
	
	@Test(priority=2)
	public void get_user()
	{
		Response response=Store_Endpoints.Read_request(this.data.getPetid());
			response.then().statusCode(200)
			.log().all();
	}
	
	@Test(priority=3)
	public void delete_user()
	{
		Response response=Store_Endpoints.Delete_request(this.data.getPetid());
	}
}
