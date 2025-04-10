package configurationpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class ShiftConfigPage extends TestBase{
	
	@FindBy(xpath="//i[@class='fas fa-plus-circle']")
	WebElement addnewshift;
	
	@FindBy(xpath="//input[@id='validationCustom01']")
	WebElement shiftid;
	
	@FindBy(xpath="//input[@id='validationCustom02']")
	WebElement shiftname;
	
	@FindBy(xpath="//select[@id='validationCustom03']")
	WebElement shiftstarttime;
	
	@FindBy(xpath="//select[@id='validationCustom04']")
	WebElement shiftendtime;
	
	@FindBy(xpath="//label[@for='invalidCheck']")
	WebElement checktick;
	
	@FindBy(xpath="//button[normalize-space()='Add']")
	WebElement adddowntimebtn;
	
	@FindBy(xpath="//select[@id='validationCustom06']")
	WebElement downtimeduration;
	
	@FindBy(xpath="//input[@id='validationCustom05']")
	WebElement downtimename;
	
	@FindBy(xpath="//select[@id='validationCustom07']")
	WebElement startdowntime;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement shiftaddbtn;
	
	public ShiftConfigPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public MachineConfiguration createShift(String sid,String sname,String sstarttime,String sendtime,String dtduration,String dtstart)
	{
		addnewshift.click();
		shiftid.sendKeys(sid);
		shiftname.sendKeys(sname);
		dropdown(shiftstarttime, sstarttime);
		dropdown(shiftendtime, sendtime);
		checktick.click();
		adddowntimebtn.click();
		downtimename.sendKeys("D1");
		dropdown(downtimeduration, dtduration);
		dropdown(startdowntime, dtstart);
		shiftaddbtn.click();
		
		return new MachineConfiguration();
	}
	
	
//	public static void dropdown(WebElement xpath, String value)
//	{
//		Select s =new Select(xpath);
//		s.selectByVisibleText(value);
//	}
}
