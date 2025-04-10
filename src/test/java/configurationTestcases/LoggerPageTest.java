package configurationTestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import configurationpages.ConfigurationPage;
import configurationpages.LoggerPage;
import configurationpages.MachineConfiguration;
import configurationpages.ShiftConfigPage;
import homePages.LoginPage;
import homePages.PlantDashboard;
import util.Testutil;

public class LoggerPageTest extends TestBase {

	LoginPage lp;
	PlantDashboard pd;
	ConfigurationPage cp;
	MachineConfiguration mcp;
	LoggerPage lcp;
	String sheetname="LoggerConfig";
	
	public LoggerPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		lp=new LoginPage();
		pd=lp.login(prop.getProperty("username"),prop.getProperty("password"));
		cp=new ConfigurationPage();
		mcp = new MachineConfiguration();
		lcp = new LoggerPage();
	}
	
	@DataProvider
	public Object[][] testdatafile()
	{
		Object[][] data = Testutil.getTestData(sheetname);
		return data;
	}
	
	@Test(dataProvider = "testdatafile")
	public void newloggerTest(String LoggerType,String LoggerId, String LoggerName,String IP,String Port, String Frequency, String ConnectionTimeout, String Plant,String Zone,String Machine,String OEEType)
	{
		pd.clickconfigpage();
		cp.clickrole();
		cp.clicklogger();
		lcp.createlogger(LoggerType, LoggerId, LoggerName, IP, Port, Frequency, ConnectionTimeout, Plant, Zone, Machine, OEEType );
		
		System.out.println(LoggerId+" is Added");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
