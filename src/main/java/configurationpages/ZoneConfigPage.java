package configurationpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class ZoneConfigPage extends TestBase {
	
	@FindBy(xpath="//i[@class='fas fa-plus-circle']")
	WebElement addnewzone;
	
	@FindBy(xpath="//select[@name='name']")
	WebElement zoneid;
	
	@FindBy(xpath="//select[@id='plantName']")
	WebElement plantname;
	
	@FindBy(xpath="//input[@placeholder='Zone Name']")
	WebElement zonename;
	
	@FindBy(xpath="//button[normalize-space()='Add']")
	WebElement zoneaddbtn;
	
	public ZoneConfigPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public ShiftConfigPage createzone(String zid,String pname,String zname)
	{
		addnewzone.click();
		dropdown(zoneid, zid);
		dropdown(plantname, pname);
		zonename.sendKeys(zname);
		zoneaddbtn.click();
		
		return new ShiftConfigPage();
	}
	public static void dropdown(WebElement xpath, String value)
	{
		Select s =new Select(xpath);
		s.selectByVisibleText(value);
	}


}
