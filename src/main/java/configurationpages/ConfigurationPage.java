package configurationpages;

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
	
	public ConfigurationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickzone()
	{
		zoneconfig.click();
	}
	
	public void clickshift()
	{
		shiftconfig.click();
	}

	public void clickrole() {
		// TODO Auto-generated method stub
		roleclick.click();
	}
	
	public UserConfigPage clickuser()
	{
		
		userconfig.click();
		
		return new UserConfigPage();
	}
}
