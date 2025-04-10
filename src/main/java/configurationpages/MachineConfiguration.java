package configurationpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class MachineConfiguration extends TestBase {
	
	@FindBy(xpath="//i[@class='fas fa-plus-circle']")
	WebElement addnewmachine;
	
	@FindBy(xpath="//input[@placeholder='Machine ID']")
	WebElement machid;
	
	@FindBy(xpath="//input[@placeholder='Machine Name']")
	WebElement machname;

	@FindBy(xpath="//select[@id='typedata']")
	WebElement model;
	
	@FindBy(xpath="//input[@placeholder='Manufacturer']")
	WebElement manufacturer;
	
	@FindBy(xpath="//select[@id='plantName']")
	WebElement plant;
	
	@FindBy(xpath="//select[@id='zoneName']")
	WebElement zone;
	
	@FindBy(xpath="//select[@id='type']")
	WebElement machtype;
	
	@FindBy(xpath="//button[normalize-space()='Add']")
	WebElement addbtn;
	
	@FindBy(xpath="//span[@aria-hidden='true']")
	WebElement backintobtn;
	
	public MachineConfiguration()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createmachine(String mid,String mname, String mdl, String manfac, String mplt, String mZn, String mtype)
	{
		addnewmachine.click();
		machid.sendKeys(mid);
		machname.sendKeys(mname);
		dropdown(model, mdl);
		manufacturer.sendKeys(manfac);
		dropdown(plant, mplt);
		dropdown(zone, mZn);
		dropdown(machtype, mtype);
		addbtn.click();
	}
	
	public LoggerPage loggernavigation()
	{
		return new LoggerPage();
	}
}
