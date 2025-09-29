package homePages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import configurationpages.ConfigurationPage;
import util.Testutil;

public class PlantDashboard extends TestBase {

    @FindBy(xpath="(//div[@class='card-header header-style text-center'])[1]")
    WebElement zoneclick;

    @FindBy(xpath="//i[@class='fa fa-2x fa-cog']")
    WebElement configpage;

    // Example: Add an element to validate dashboard loaded
    @FindBy(xpath="//div[@id='toast-container']")
    WebElement toasterContainer;

    // Initializing page objects
    public PlantDashboard() {
        PageFactory.initElements(driver, this);
    }

    // Actions
    public String verifyPlantDashboardTitle() {
        return driver.getTitle();
    }

    public ZoneDashboard verifyzoneclick() {
        zoneclick.click();
        return new ZoneDashboard();
    }

    public ConfigurationPage clickconfigpage() {
        configpage.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Testutil.IMPLICIT_WAIT));
        return new ConfigurationPage();
    }

    // Check if dashboard loaded successfully
    public boolean isDashboardVisible() {
        try {
            return toasterContainer.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
