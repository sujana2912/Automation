package homepageTestcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import homePages.LoginPage;
import homePages.PlantDashboard;

@Listeners(listners.TestListener.class)
public class LoginTest extends TestBase {
    
    LoginPage lp;
    PlantDashboard pd;

    public LoginTest() {
        super();
    }

    @BeforeClass
    public void setup() {
        intialization();   // initialize driver once for all tests
        lp = new LoginPage();
    }

    @Test(priority = 1)
    public void testtitleTest() {
        System.out.println("Test Start: testtitleTest");
        String title = lp.validatetitle();
        Assert.assertEquals(title, "Wimera");
        //System.out.println("Test Success: testtitleTest");
    }

    @Test(priority = 2)
    public void logoTest() {
        System.out.println("Test Start: logoTest");
        boolean logo = lp.validatelogo();
        Assert.assertTrue(logo);
       // System.out.println("Test Success: logoTest");
    }

    @Test(priority = 3)
    public void loginTest() {
        System.out.println("Test Start: loginTest");
        pd = lp.login(prop.getProperty("username"), prop.getProperty("password"));
        //System.out.println("Test Success: loginTest");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();  // close driver only once after all tests
        }
        //System.out.println("All tests finished, browser closed");
    }
}
