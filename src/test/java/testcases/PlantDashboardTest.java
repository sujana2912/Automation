package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import pages.PlantDashboard;

public class PlantDashboardTest extends TestBase {

	LoginPage lp;
	PlantDashboard pd;

	public PlantDashboardTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		intialization();
		lp= new LoginPage();
		pd = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void hometitleTest()
	{
		String hometitle = pd.verifyPlantDashboardtitle();
		Assert.assertEquals(hometitle, "Wimera","Homepage title is not matched");
	}
	
	@Test(priority = 2)
	public void verifyzoneTest()
	{
		pd.verifyzoneclick();
	}

	@AfterMethod
	public void quit()
	{
		driver.quit();
	}
}
