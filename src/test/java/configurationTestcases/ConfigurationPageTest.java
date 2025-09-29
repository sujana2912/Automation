package configurationTestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TestBase;
import configurationpages.ConfigurationPage;
import homePages.LoginPage;
import homePages.PlantDashboard;

public class ConfigurationPageTest extends TestBase {
    
    LoginPage lp;
    PlantDashboard pd;
    ConfigurationPage cp;
    
    public ConfigurationPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        intialization();
        lp = new LoginPage();
        pd = lp.login(prop.getProperty("username"), prop.getProperty("password"));
        cp = pd.clickconfigpage();   // navigate from dashboard to config
    }
    
    @Test(priority = 1)
    public void verifyClickRole() throws InterruptedException{
        cp.clickrole();
        Thread.sleep(1500);
        Assert.assertTrue(true, "Role section not clickable!");
    }

    @Test(priority = 2)
    public void verifyClickUser() throws InterruptedException{
    	cp.clickrole();
        cp.clickuser();
        Thread.sleep(1500);
        Assert.assertTrue(true, "User section not clickable!");
    }

    @Test(priority = 3)
    public void verifyClickZone() throws InterruptedException{
    	cp.clickrole();
        cp.clickzone();
        Thread.sleep(1500);
        Assert.assertTrue(true, "Zone section not clickable!");
    }

    @Test(priority = 4)
    public void verifyClickShift() throws InterruptedException{
    	cp.clickrole();
        cp.clickshift();
        Thread.sleep(1500);
        Assert.assertTrue(true, "Shift section not clickable!");
    }

    @Test(priority = 5)
    public void verifyClickMachine() throws InterruptedException{
    	cp.clickrole();
        cp.clickmachine();
        Thread.sleep(1500);
        Assert.assertTrue(true, "Machine section not clickable!");
    }

    @Test(priority = 6)
    public void verifyClickLogger() throws InterruptedException{
    	cp.clickrole();
        cp.clicklogger();
        Thread.sleep(1500);
        Assert.assertTrue(true, "Logger section not clickable!");
    }

    @Test(priority = 7)
    public void verifyClickTargetPart() throws InterruptedException {
    	cp.clickrole();
        cp.clicktargetpart();
        Thread.sleep(1500);
        Assert.assertTrue(true, "Target Part section not clickable!");
    }
    
    @AfterMethod
    public void close() {
        driver.quit();
    }
}
