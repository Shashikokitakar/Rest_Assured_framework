package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.User_End_Points;
import api.payload.User;
import io.restassured.response.Response;


public class User_Test_Case {
	
	Faker faker;
	
	User user_data;
	Logger Log;
	
	@BeforeClass()
	public void Setup_data()
	{
		faker= new Faker();
		
		user_data= new User();
		
		user_data.setId(faker.idNumber().hashCode());
		
		user_data.setUsername(faker.name().username());
		
		user_data.setFirstName(faker.name().firstName());
		
		user_data.setLastName(faker.name().lastName());
		
		user_data.setEmail(faker.internet().safeEmailAddress());
		
		user_data.setPassword(faker.internet().password(5, 13));
		
		user_data.setPhone(faker.phoneNumber().cellPhone());
		
		user_data.setUserStatus(0);
		
		Log=LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void create_user()
	{
		Log.info("################### Creating a new User ########################");
		Response response=User_End_Points.Create_User(user_data);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Log.info("################### Created a User ########################");
	}
	
	@Test(priority=2)
	public void get_user()
	{
		Log.info("################### Fetching a new User ########################");
		Response response=User_End_Points.read_User(this.user_data.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Log.info("################### User Fetched ########################");
	}
	
	@Test(priority=3)
	
	public void update_user()
	{
		user_data.setFirstName(faker.name().firstName());
		
		user_data.setLastName(faker.name().lastName());
		
		user_data.setEmail(faker.internet().safeEmailAddress());
		
		user_data.setPassword(faker.internet().password(5, 13));
		
		Log.info("################### Update a new User ########################");
		
		Response response=User_End_Points.Update_User(this.user_data.getUsername(),user_data);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Response response1=User_End_Points.read_User(this.user_data.getUsername());
		
		response1.then().log().all();
		
		Assert.assertEquals(response1.getStatusCode(), 200);
		
		Log.info("################### Updated a new User ########################");
		
	}
	
	@Test(priority=4)
	public void delete_user()
	{
		Log.info("################### Deliting a new User ########################");
		Response response=User_End_Points.delete_User(this.user_data.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Log.info("################### Deleted a new User ########################");
	}
	

}
