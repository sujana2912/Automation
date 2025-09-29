package homepageTestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import homePages.LoginPage;
import homePages.PlantDashboard;

public class PlantDashboardTest extends TestBase {

    LoginPage lp;
    PlantDashboard pd;

    public PlantDashboardTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        intialization();
        lp = new LoginPage();
        pd = lp.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void homeTitleTest() {
        String homeTitle = pd.verifyPlantDashboardTitle();
        Assert.assertEquals(homeTitle, "Wimera", "Homepage title is not matched!");
        System.out.println("Homepage title validated: " + homeTitle);
    }

    @Test(priority = 2)
    public void dashboardVisibleTest() {
        boolean isVisible = pd.isDashboardVisible();
        Assert.assertTrue(isVisible, "Dashboard is not visible after login!");
        System.out.println("Dashboard is visible after login.");
    }

    @Test(priority = 3)
    public void verifyZoneClickTest() {
        // Click zone and validate
        pd.verifyzoneclick();
        // Add optional assertion if ZoneDashboard has some visible element
        System.out.println("Zone clicked successfully.");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
