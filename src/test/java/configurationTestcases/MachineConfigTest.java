package configurationTestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import configurationpages.ConfigurationPage;
import configurationpages.MachineConfiguration;
import configurationpages.ShiftConfigPage;
import homePages.LoginPage;
import homePages.PlantDashboard;
import util.Testutil;

public class MachineConfigTest extends TestBase{

	LoginPage lp;
	PlantDashboard pd;
	ConfigurationPage cp;
	ShiftConfigPage scp;
	MachineConfiguration mcp;
	String sheetname="MachineConfig";
	
	public MachineConfigTest() {
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
		mcp = new MachineConfiguration();
	}
	
	@DataProvider
	public Object[][] testdatafile()
	{
		Object[][] data = Testutil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=1,dataProvider = "testdatafile")
	public void newmachineTest(String MachineId,String MachineName, String Model,String Manufacturer,String Plant,String Zone,String MachineType)
	{
		pd.clickconfigpage();
		cp.clickrole();
		cp.clickmachine();
		mcp.createmachine(MachineId, MachineName, Model, Manufacturer, Plant, Zone, MachineType);
		
		System.out.println("Added");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
