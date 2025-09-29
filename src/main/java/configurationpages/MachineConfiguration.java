package configurationpages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import util.Testutil;

public class MachineConfiguration extends TestBase {
	
	@FindBy(xpath="//i[@class='fas fa-plus-circle']")
	WebElement addnewmachine;
	
	@FindBy(xpath="//input[@placeholder='Machine ID']")
	WebElement machid;
	
	@FindBy(xpath="//input[@placeholder='Machine Name']")
	WebElement machname;

	@FindBy(xpath="//select[@id='typedata']")
	static
	WebElement model;
	
	@FindBy(xpath="//input[@placeholder='Manufacturer']")
	WebElement manufacturer;
	
	@FindBy(xpath="//select[@id='plantName']")
	WebElement plant;
	
	@FindBy(xpath="//select[@id='zoneName']")
	WebElement zone;
	
	@FindBy(xpath="//select[@id='type']")
	WebElement machtype;
	
	@FindBy(xpath="//select[@id='palletType']")
	WebElement pallettype;
	
	@FindBy(xpath="//button[normalize-space()='Add']")
	WebElement addbtn;
	
	@FindBy(xpath="//span[@aria-hidden='true']")
	WebElement backintobtn;
	
	public MachineConfiguration()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createmachine(String mid,String mname,String mdl, String manfac, String mplt, String mZn, String mtype, String pltype)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Testutil.IMPLICIT_WAIT));
		addnewmachine.click();
		machid.sendKeys(mid);
		machname.sendKeys(mname);
		Testutil.safeSelectDropdown(model, mdl);
		manufacturer.sendKeys("Wimera");
		Testutil.safeSelectDropdown(plant, mplt);
		Testutil.safeSelectDropdown(zone, mZn);
		Testutil.safeSelectDropdown(machtype, mtype);
		Testutil.safeSelectDropdown(pallettype, pltype);		

		    addbtn.click();;
	}
	// In MachineConfiguration.java
	public WebElement getModelDropdown() {
	    return model;
	}

	
	public LoggerPage loggernavigation()
	{
		return new LoggerPage();
	}
}
