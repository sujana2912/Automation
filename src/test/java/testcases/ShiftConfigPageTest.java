package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import configurationpages.*;
import homePages.LoginPage;
import homePages.PlantDashboard;
import util.Testutil;

public class ShiftConfigPageTest extends TestBase {

	LoginPage lp;
	PlantDashboard pd;
	ConfigurationPage cp;
	ShiftConfigPage scp;
	String sheetname="ShiftConfig";
	
	public ShiftConfigPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		lp=new LoginPage();
		pd=lp.login(prop.getProperty("username"),prop.getProperty("password"));
		cp=new ConfigurationPage();
		scp = new ShiftConfigPage();
		
	}
	
	@DataProvider
	public Object[][] testdatafile()
	{
		Object[][] data = Testutil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=1,dataProvider = "testdatafile")
	public void newuserTest(String ShiftId,String ShiftName, String StartTime,String EndTime,String DowntimeDuration,String DowntimeStart)
	{
		pd.clickconfigpage();
		cp.clickrole();
		cp.clickshift();
		
		scp.createShift(ShiftId, ShiftName, StartTime, EndTime, DowntimeDuration, DowntimeStart);
		
		System.out.println("Added");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
