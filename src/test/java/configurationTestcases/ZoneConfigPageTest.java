package configurationTestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import configurationpages.ZoneConfigPage;
import homePages.LoginPage;
import homePages.PlantDashboard;
import configurationpages.*;
import util.Testutil;

public class ZoneConfigPageTest extends TestBase {

	LoginPage lp;
	PlantDashboard pd;
	ConfigurationPage cp;
	ZoneConfigPage zcp;
	String sheetname="ZoneConfig";

	public ZoneConfigPageTest()
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
		zcp=new ZoneConfigPage();
	}

	@DataProvider
	public Object[][] testdatafile()
	{
		Object[][] data = Testutil.getTestData(sheetname);
		return data;
	}

	@Test(priority=1,dataProvider = "testdatafile")
	public void newuserTest(String ZoneId,String PlantName, String ZoneName)
	{
		pd.clickconfigpage();
		cp.clickrole();
		cp.clickzone();

		zcp.createzone(ZoneId, PlantName, ZoneName);

		System.out.println("Added");
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
