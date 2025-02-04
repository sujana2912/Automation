package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ZoneDashboard extends TestBase {
	
	@FindBy(xpath="//div[normalize-space()='Plant-1']")
	WebElement zonepagetitle;
	
	@FindBy(xpath="//i[@class='fas fa-list']")
	WebElement listpattern;
	
	@FindBy(xpath="//i[@class='fas fa-chart-line']")
	WebElement linepattern;
	
	@FindBy(xpath="(//div[@class=\"card-header header-style text-center\"])[1]")
	WebElement clickmach1;
	
	public ZoneDashboard()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean zdtitleTest()
	{
		return zonepagetitle.isDisplayed();
	}
	
	public void listlinepatternsTest()
	{
		listpattern.click();
		linepattern.click();
	}
	public MachineDashboard clickmachTest()
	{
		clickmach1.click();
		return new MachineDashboard();
	}

}
