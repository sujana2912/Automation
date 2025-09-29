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
	
	int totalShifts = Testutil.getShiftCountFromExcel();
	
	@Test(priority=1,dataProvider = "testdatafile")
	public void newuserTest(String ShiftId,String ShiftName, String StartTime,String EndTime,String DowntimeDuration,String DowntimeStart, int rowIndex)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Testutil.IMPLICIT_WAIT));
		pd.clickconfigpage();
		cp.clickrole();
		cp.clickshift();
		boolean isLastShift = (rowIndex == totalShifts - 1);
		scp.createShift(ShiftId, ShiftName, StartTime, EndTime, DowntimeDuration, DowntimeStart, isLastShift);
		
		System.out.println("Added");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
