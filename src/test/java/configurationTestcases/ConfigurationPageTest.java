package configurationTestcases;

import java.time.Duration;

import org.checkerframework.checker.units.qual.cd;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import configurationpages.*;
import homePages.LoginPage;
import homePages.PlantDashboard;
import util.Testutil;

public class ConfigurationPageTest extends TestBase {
	
	LoginPage lp;
	PlantDashboard pd;
	ConfigurationPage cp;
	
	public ConfigurationPageTest()
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
	}
	
	@Test(priority=1)
	public void clickconfigpageTest()
	{
		pd.clickconfigpage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Testutil.PAGE_LOAD_TIMEOUT));
		cp.clickrole();
		cp.clickuser();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Testutil.IMPLICIT_WAIT));
		
	}
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	
}
