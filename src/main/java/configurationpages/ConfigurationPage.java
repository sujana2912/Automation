package configurationpages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class ConfigurationPage extends TestBase{
	
	@FindBy(xpath="(//span[normalize-space()='1'])[1]")
	WebElement roleclick;
	
	@FindBy(xpath="//span[normalize-space()='User']")
    WebElement userconfig;
	
	@FindBy(xpath="//span[normalize-space()='Zone']")
	WebElement zoneconfig;
	
	@FindBy(xpath="//span[normalize-space()='Shift']")
	WebElement shiftconfig;
	
	@FindBy(xpath="//span[normalize-space()='Machine']")
	WebElement machconfig;
	
	@FindBy(xpath="//span[normalize-space()='Logger']")
	WebElement loggerconfig;
	
	@FindBy(xpath="//span[normalize-space()='Target Part']")
	WebElement Targetpartconfig;
	
	public ConfigurationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickzone()
	{
		zoneconfig.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void clickshift()
	{
		shiftconfig.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void clickmachine()
	{
		machconfig.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void clicklogger()
	{
		loggerconfig.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void clicktargetpart()
	{
		Targetpartconfig.click();
		
	}

	public void clickrole() {
		// TODO Auto-generated method stub
		roleclick.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public UserConfigPage clickuser()
	{
		
		userconfig.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return new UserConfigPage();
	}
}
