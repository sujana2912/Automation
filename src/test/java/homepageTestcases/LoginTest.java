package homepageTestcases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import homePages.LoginPage;
import homePages.PlantDashboard;
import util.Testutil;

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
    public void testTitle() {
        System.out.println("Test Start: testTitle");
        String title = lp.validatetitle();
        Assert.assertEquals(title, "Wimera", "Login page title is incorrect!");
    }

    @Test(priority = 2)
    public void logoTest() {
        System.out.println("Test Start: logoTest");
        boolean logoDisplayed = lp.validatelogo();
        Assert.assertTrue(logoDisplayed, "Login page logo is not displayed!");
       
    }

    @Test(priority = 3)
    public void loginTest() {
       
        pd = lp.login(prop.getProperty("username"), prop.getProperty("password"));

        // Wait for some element in PlantDashboard to ensure login was successful
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Testutil.IMPLICIT_WAIT));
        boolean dashboardVisible = pd.isDashboardVisible(); // You need to create this method in PlantDashboard
        Assert.assertTrue(dashboardVisible, "Login failed or dashboard not visible!");
        System.out.println("Login successful, dashboard visible.");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();  // close driver only once after all tests
        }
        
    }
}
