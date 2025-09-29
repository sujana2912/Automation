package configurationTestcases;

import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import configurationpages.*;
import homePages.LoginPage;
import homePages.PlantDashboard;
import util.Testutil;

public class UserConfigTest extends TestBase {

    LoginPage lp;
    PlantDashboard pd;
    ConfigurationPage cp;
    UserConfigPage ucp;
    String sheetname = "UserConfig";

    public UserConfigTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        intialization();
        lp = new LoginPage();
        pd = lp.login(prop.getProperty("username"), prop.getProperty("password"));
        cp = new ConfigurationPage();
        ucp = new UserConfigPage();
    }

    @DataProvider
    public Object[][] testdatafile() {
        Object[][] data = Testutil.getTestData(sheetname);
        return data;
    }

    @Test(priority = 1, dataProvider = "testdatafile")
    public void newUserTest(String UserId, String Username, String EmailId, String Role, String MobileNo, String Password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Testutil.IMPLICIT_WAIT));

        pd.clickconfigpage();
        Thread.sleep(1500); // 👀 Wait so you can see the navigation

        cp.clickrole();
        Thread.sleep(1500);

        cp.clickuser();
        Thread.sleep(1500);

        ucp.clickAddUser();
        Thread.sleep(1500);

        String toasterMsg = ucp.createUser(UserId, Username, EmailId, Role, Password);
        Thread.sleep(2000); // 👀 Wait to see toaster appear

        // ✅ Normalize toaster message to handle line breaks / spaces
        String normalizedMsg = toasterMsg != null ? toasterMsg.replaceAll("\\s+", " ").trim() : null;
        System.out.println("Normalized toaster message: " + normalizedMsg);

        // ✅ Assertion to verify user is added
        Assert.assertNotNull(toasterMsg, "Toaster message did not appear!");
        Assert.assertTrue(normalizedMsg.contains("User Added Successfully") || normalizedMsg.contains("successfully"),
                "User was not added! Toaster message: " + normalizedMsg);

        System.out.println("🎉 " + UserId + " is added successfully.");
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000); // 👀 wait before quitting browser so you can see result
        driver.quit();
    }
}
