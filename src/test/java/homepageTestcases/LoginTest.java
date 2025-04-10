package homepageTestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import homePages.LoginPage;
import homePages.PlantDashboard;


@Listeners(listners.TestListener.class)
public class LoginTest extends TestBase{
	LoginPage lp;
	PlantDashboard pd;
	
	public LoginTest()
	{
		super();
	}	
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		lp = new LoginPage();
	}
	
	@Test(priority = 1)
	public void testtitleTest()
	{
		String title = lp.validatetitle();
		Assert.assertEquals(title, "Wimera");
	}
	
	@Test(priority = 2)
	public void logoTest()
	{
		boolean logo = lp.validatelogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority = 3)
	public void loginTest()
	{
		pd = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearsdown()
	{
		driver.quit();
	}
	
}