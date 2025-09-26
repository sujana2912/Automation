package configurationTestcases;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import configurationpages.*;
import homePages.LoginPage;
import homePages.PlantDashboard;
import util.Testutil;

public class UserConfigTest extends TestBase {

	LoginPage lp;
	PlantDashboard pd;
	ConfigurationPage cp;
	UserConfigPage ucp;
	String sheetname="UserConfig";
	Testutil testutil;

	public UserConfigTest()
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
		ucp=new UserConfigPage();
	}

	
	@Test(priority=1)
	public void clickadduserTest()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(testutil.PAGE_LOAD_TIMEOUT));
		pd.clickconfigpage();
		cp.clickrole();
		cp.clickuser();
		ucp.clickadduser();
	}
	
	@DataProvider
	public Object[][] testdatafile()
	{
		Object[][] data = Testutil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=2,dataProvider = "testdatafile")
	public void newuserTest(String UserId,String Username, String EmailId, String Role, String MobileNo,String Password)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Testutil.IMPLICIT_WAIT));
		pd.clickconfigpage();
		cp.clickrole();
		cp.clickuser();
		ucp.clickadduser();
		ucp.createuser(UserId,Username,EmailId,Role,Password);
		System.out.println(UserId+" is Added");
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}


}
