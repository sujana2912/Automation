package configurationpages;

import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import util.Testutil;

public class UserConfigPage extends TestBase {

    @FindBy(xpath = "//i[@class='fas fa-plus-circle']")
    WebElement useraddconfig;

    @FindBy(xpath = "//input[@placeholder='User Id']")
    WebElement userid;

    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement username;

    @FindBy(xpath = "//input[@placeholder='Email-id']")
    WebElement useremail;

    @FindBy(xpath = "//select[@id='role']")
    WebElement userrole;

    @FindBy(xpath = "//input[@id='userMobile']")
    WebElement usermobileno;

    @FindBy(xpath = "//input[@id='newuserpassword']")
    WebElement userpwd;

    @FindBy(xpath = "//div[@id='toast-container']")
    WebElement toaster;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement savebtn;

    // Initialize page objects
    public UserConfigPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickAddUser() {
        useraddconfig.click();
    }

    // Create user and return toaster message
    public String createUser(String uid, String Uname, String EmailId, String role, String pwd) {
        userid.sendKeys(uid);
        username.sendKeys(Uname);
        useremail.sendKeys(EmailId);

        Select s = new Select(userrole);
        s.selectByVisibleText(role);

        String mNo = RandomStringUtils.randomNumeric(10);
        usermobileno.sendKeys(mNo);

        userpwd.sendKeys(pwd);
        savebtn.click();

        return Testutil.getToasterMessage(driver);
        
    }
}
