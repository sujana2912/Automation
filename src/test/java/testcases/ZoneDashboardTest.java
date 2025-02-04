package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import pages.PlantDashboard;
import pages.ZoneDashboard;

public class ZoneDashboardTest extends TestBase
{
	LoginPage lp;
	PlantDashboard pd;
	ZoneDashboard zd;

	public ZoneDashboardTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		intialization();
		lp= new LoginPage();
		pd = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		pd.verifyzoneclick();
		zd = new ZoneDashboard();
	}

//	@Test(priority = 1)
//	public void verifypd()
//	{
//		Assert.assertEquals(pd.pdtitle(),"Plant-1","not matching the title");
//	}

	@Test(priority=1)
	public void verifypatternsTest()
	{
		zd.listlinepatternsTest();
	}
	
	@Test(priority=2)
	public void machineclickTest()
	{
		zd.clickmachTest();
	}
	
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}
}
