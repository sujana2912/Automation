package configurationpages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class LoggerPage extends TestBase {

	@FindBy(xpath="//i[@class='fas fa-plus-circle']")
	WebElement addnewlogger;
	
	@FindBy(id="typedata")
	WebElement loggertype;
	
	@FindBy(xpath="//input[@placeholder='Logger Id']")
	WebElement logid;

	@FindBy(xpath="//input[@placeholder='Logger Name']")
	WebElement logname;
	
	@FindBy(xpath="//input[@placeholder='IP']")
	WebElement logIP;
	
	@FindBy(xpath="//input[@placeholder='Port']")
	WebElement port;
	
	@FindBy(xpath="//select[@id='freq']")
	WebElement frequency;
	
	@FindBy(xpath="//select[@id='conntime']")
	WebElement connectionTimeout;
	
	@FindBy(xpath="//select[@id='plantName']")
	WebElement selectplant;
	
	@FindBy(xpath="//select[@id='zoneName']")
	WebElement selectzone;
	
	@FindBy(xpath="//select[@id='machine']")
	WebElement selectmachine;
	
	@FindBy(xpath="//select[@id='config']")
	WebElement selectoeetype;
	
	@FindBy(xpath="//button[normalize-space()='Add']")
	WebElement addbtn;
	
	@FindBy(xpath="//span[@aria-hidden='true']")
	WebElement backintobtn;
	
	public LoggerPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createlogger(String ltype, String lid,String lname, String lIP, String lpt, String frq, String cto, String pltp, String ztp, String Mtype, String oee)
	{
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		addnewlogger.click();
		
		//wait.until(ExpectedConditions.visibilityOf(loggertype));
	    dropdown(loggertype, ltype);
	    
		logid.sendKeys(lid);
		logname.sendKeys(lname);
		logIP.sendKeys(lIP);
		port.sendKeys(lpt);
		dropdown(frequency, frq);
		dropdown(connectionTimeout, cto);
		dropdown(selectplant, pltp);
		dropdown(selectzone, ztp);
		dropdown(selectmachine, Mtype);
		dropdown(selectoeetype, oee);
		addbtn.click();
	}
	
	public TargetpartPage loggernavigation()
	{
		return new TargetpartPage();
	}

}
