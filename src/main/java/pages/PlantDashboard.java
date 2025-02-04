package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class PlantDashboard extends TestBase {
	
	@FindBy(xpath="(//div[@class='card-header header-style text-center'])[1]")
	WebElement zoneclick;
	
	//intializing page objects
	public PlantDashboard()
	{
		PageFactory.initElements(driver, this);
		
	}
		
	//Actions
	public String verifyPlantDashboardtitle()
	{
		return driver.getTitle();
	}
	
	public ZoneDashboard verifyzoneclick()
	{
		System.out.println(zoneclick);
		zoneclick.click();
		return new ZoneDashboard();
	}
	
}
