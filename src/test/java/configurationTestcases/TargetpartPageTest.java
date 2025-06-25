package configurationTestcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import configurationpages.ConfigurationPage;
import configurationpages.LoggerPage;
import configurationpages.MachineConfiguration;
import configurationpages.TargetpartPage;
import homePages.LoginPage;
import homePages.PlantDashboard;
import util.Testutil;

public class TargetpartPageTest extends TestBase {

    LoginPage lp;
    PlantDashboard pd;
    ConfigurationPage cp;
    TargetpartPage tpp;
    String sheetname = "TargetPartConfig";

    public TargetpartPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        intialization();
        lp = new LoginPage();
        pd = lp.login(prop.getProperty("username"), prop.getProperty("password"));
        cp = new ConfigurationPage();
        tpp = new TargetpartPage();
    }

    @DataProvider
    public Object[][] testdatafile() {
        return Testutil.getTestData(sheetname);
    }

    @Test()
    public void addtargetpartTest() throws InterruptedException {
        pd.clickconfigpage();
        cp.clickrole();
        cp.clicktargetpart();
        tpp.addtargetpart();
        System.out.println("Targetpart is added");
    }
}
