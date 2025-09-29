// ZoneConfigPage.java
package configurationpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import base.TestBase;
import util.Testutil;

public class ZoneConfigPage extends TestBase {

    @FindBy(xpath = "//i[@class='fas fa-plus-circle']")
    WebElement addnewzone;

    @FindBy(xpath = "//select[@name='name']")
    WebElement zoneid;

    @FindBy(xpath = "//select[@id='plantName']")
    WebElement plantname;

    @FindBy(xpath = "//input[@placeholder='Zone Name']")
    WebElement zonename;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement zoneaddbtn;

    @FindBy(xpath = "//div[@id='toast-container']")
    WebElement toaster;
    
    public ZoneConfigPage() {
        PageFactory.initElements(driver, this);
    }

    public String createzone(String zid, String pname, String zname) {
        addnewzone.click();
        Testutil.dropdown(zoneid, zid);
        Testutil.dropdown(plantname, pname);
        zonename.sendKeys(zname);
        zoneaddbtn.click();

     // Wait for toaster (visible for up to 5 seconds)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement t = wait.until(ExpectedConditions.visibilityOf(toaster));
            String msg = t.getText();
            System.out.println("✅ Toaster message: " + msg);
            return msg;
        } catch (Exception e) {
            System.out.println("⚠ Toaster did not appear or disappeared too quickly.");
            return null;
        }
    }
}
