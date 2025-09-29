package homepageTestcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TestBase;
import homePages.LoginPage;
import homePages.PlantDashboard;
import homePages.ZoneDashboard;
import homePages.MachineDashboard;

public class ZoneDashboardTest extends TestBase {

	LoginPage lp;
	PlantDashboard pd;
	ZoneDashboard zd;
	MachineDashboard md;

	public ZoneDashboardTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		intialization();
		lp = new LoginPage();
		// Login and navigate
		pd = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		zd = pd.verifyzoneclick(); // returns ZoneDashboard directly
	}

	@Test(priority = 1)
	public void verifyZoneTitleTest() {
		Assert.assertTrue(zd.zdtitleTest(), "Zone Dashboard title not displayed!");
	}

	@Test(priority = 2)
	public void verifypatternsTest() {
		zd.listlinepatternsTest();
		// Small assertion to confirm the chart-line pattern is visible
		Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fas fa-chart-line']")).isDisplayed(),
				"Line pattern not activated!");
	}

	@Test(priority = 3)
	public void machineclickTest() {
		md = zd.clickmachTest();
		// Assert machine dashboard is displayed
		Assert.assertTrue(driver.findElement(By.xpath("//h4[contains(text(),'Machine Dashboard')]")).isDisplayed(),
				"Machine Dashboard not loaded!");
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
