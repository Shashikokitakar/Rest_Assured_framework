package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders 
{
	@DataProvider(name = "User_info")
	public String[][] All_Data() throws IOException
	{
		String path=System.getProperty("user.dir")+"//TestData//TestData.xlsx";
		
		XcelUtility utility=new XcelUtility(path);
		
		int rownum=utility.getRowCount("Sheet1");
		
		int columnum=utility.getCellCount("Sheet1", rownum);
		
		String apiData[][]=new String[rownum][columnum];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<columnum;j++)
			{
				apiData[i-1][j]=utility.getcelldata("Sheet1", i, j);
				
			}
			
		}
		return apiData;
	}
	
	@DataProvider(name = "user_name")
	public String[] userName() throws IOException
	{
		String path=System.getProperty("user.dir")+"//TestData//TestData.xlsx";
		
		XcelUtility utility=new XcelUtility(path);
		
		int rownum=utility.getRowCount("Sheet1");
		
		
		String apiData[]=new String[rownum];
		for(int i=1;i<=rownum;i++)
		{
				apiData[i-1]=utility.getcelldata("Sheet1", i, 1);
				
			
			
		}
		return apiData;
	}
}
