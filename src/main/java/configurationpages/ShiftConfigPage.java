package configurationpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class ShiftConfigPage extends TestBase{
	
	@FindBy(xpath="//i[@class='fas fa-plus-circle']")
	WebElement addnewshift;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement shiftid;
	
	@FindBy(xpath="input[placeholder='Shift Name']")
	WebElement shiftname;
	
	@FindBy(xpath="//input[@class='form-control form-control-sm ng-untouched ng-pristine ng-star-inserted']")
	WebElement shiftstarttime;
	
	@FindBy(xpath="//select[@name='endTime']")
	WebElement shiftendtime;
	
	@FindBy(xpath="//select[@name='plannedDownTime']")
	WebElement downtimeduration;
	
	@FindBy(xpath="//select[@name='startplannedDownTime']")
	WebElement startdowntime;
	
	@FindBy(xpath="//button[normalize-space()='Add']")
	WebElement shiftaddbtn;
	
	public ShiftConfigPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createShift(String sid,String sname,String sstarttime,String sendtime,String dtduration,String dtstart)
	{
		addnewshift.click();
		shiftid.sendKeys(sid);
		shiftname.sendKeys(sname);
		dropdown(shiftstarttime, sstarttime);
		dropdown(shiftendtime, sendtime);
		dropdown(downtimeduration, dtduration);
		dropdown(startdowntime, dtstart);
		shiftaddbtn.click();
	}
	
	public static void dropdown(WebElement xpath, String value)
	{
		Select s =new Select(xpath);
		s.selectByVisibleText(value);
	}
}
