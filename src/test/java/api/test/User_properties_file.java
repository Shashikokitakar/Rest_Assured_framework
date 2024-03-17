package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


import api.endpoints.User_End_Points2;
import api.payload.User;
import io.restassured.response.Response;

public class User_properties_file {
	
	Faker faker;
	
	User user_data;
	
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
	}
	
	@Test(priority=1)
	public void create_user()
	{
		Response response=User_End_Points2.Create_User(user_data);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void get_user()
	{
		Response response=User_End_Points2.read_User(this.user_data.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	
	public void update_user()
	{
		user_data.setFirstName(faker.name().firstName());
		
		user_data.setLastName(faker.name().lastName());
		
		user_data.setEmail(faker.internet().safeEmailAddress());
		
		user_data.setPassword(faker.internet().password(5, 13));
		
		Response response=User_End_Points2.Update_User(this.user_data.getUsername(),user_data);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Response response1=User_End_Points2.read_User(this.user_data.getUsername());
		
		response1.then().log().all();
		
		Assert.assertEquals(response1.getStatusCode(), 200);
		
	}
	
	@Test(priority=4)
	public void delete_user()
	{
		Response response=User_End_Points2.delete_User(this.user_data.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	

}
