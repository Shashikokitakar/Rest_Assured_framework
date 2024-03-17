package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.User_End_Points;
import api.payload.User;
import api.utilities.Dataproviders;
import io.restassured.response.Response;

public class Data_Driven_User_Test {
	
	@Test(priority=1, dataProvider="User_info", dataProviderClass=Dataproviders.class)
	public void Create_User(String user_ID, String User_Name, String FirstName, String LastName,String UserEmail,String UserPassword, String UserPhone, String UserStatus )
	{
		User data=new User();
		
		data.setId(Integer.parseInt(user_ID));
		data.setUsername(User_Name);
		data.setFirstName(FirstName);
		data.setLastName(LastName);
		data.setPassword(UserPassword);
		data.setPhone(UserPhone);
		data.setUserStatus(Integer.parseInt(UserStatus));
		
		Response response=User_End_Points.Create_User(data);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=2, dataProvider="user_name", dataProviderClass=Dataproviders.class)
	public void Get_User(String userName)
	{
		Response response=User_End_Points.read_User(userName);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3, dataProvider="user_name", dataProviderClass=Dataproviders.class)
	public void delete_User(String userName)
	{
		Response response=User_End_Points.delete_User(userName);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
