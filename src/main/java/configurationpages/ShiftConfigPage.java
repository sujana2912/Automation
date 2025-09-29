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
	
	@FindBy(xpath="//input[@placeholder='Shift Name']")
	WebElement shiftname;
	
	@FindBy(xpath="//select[@name='starttime']")
	WebElement shiftstarttime;
	
	@FindBy(xpath="//select[@name='endTime']")
	WebElement shiftendtime;
	
	@FindBy(xpath="//label[@for='invalidCheck']")
	WebElement checktick;
	
	@FindBy(xpath="//button[normalize-space()='Add']")
	WebElement adddowntimebtn;
	
	@FindBy(xpath="//select[@name='plannedDownTime']")
	WebElement downtimeduration;
	
	@FindBy(xpath="//input[@id='validationCustom05']")
	WebElement downtimename;
	
	@FindBy(xpath="//select[@name='startplannedDownTime']")
	WebElement startdowntime;
	
	@FindBy(xpath="//button[normalize-space()='Add']")
	WebElement shiftaddbtn;
	
	@FindBy(xpath="//input[@id='endNextDayFlag']")
	WebElement endNextDay;
	
	public ShiftConfigPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public MachineConfiguration createShift(String sid,String sname,String sstarttime,String sendtime,String dtduration,String dtstart, boolean isLastShift)
	{
		addnewshift.click();
		shiftid.sendKeys(sid);
		shiftname.sendKeys(sname);
		dropdown(shiftstarttime, sstarttime);
		dropdown(shiftendtime, sendtime);
		//checktick.click();
		//adddowntimebtn.click();
		//downtimename.sendKeys("D1");
		dropdown(downtimeduration, dtduration);
		dropdown(startdowntime, dtstart);
		if (isLastShift) {
		    endNextDay.click();
		}

		shiftaddbtn.click();
		
		return new MachineConfiguration();
	}
	
	
//	public static void dropdown(WebElement xpath, String value)
//	{
//		Select s =new Select(xpath);
//		s.selectByVisibleText(value);
//	}
}
