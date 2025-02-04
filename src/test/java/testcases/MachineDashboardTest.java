package testcases;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import pages.MachineDashboard;
import pages.PlantDashboard;
import pages.ZoneDashboard;

public class MachineDashboardTest extends TestBase {

	LoginPage lp;
	PlantDashboard pd;
	ZoneDashboard zd;
	MachineDashboard md;

	public MachineDashboardTest()
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
		zd.clickmachTest();
		md = new MachineDashboard();
	}

	@Test
	public void gnattchartTest()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		md.gnattchartbar();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}
}
