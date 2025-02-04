package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement username;

	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath ="//button[@class='login100-form-btn']")
	WebElement loginbutton;

	@FindBy(xpath="//div[@class='login100-pic js-tilt']")
	WebElement logo;

	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		
	}

	public String validatetitle()
	{
		return driver.getTitle();
	}
	
	public boolean validatelogo()
	{
		return logo.isDisplayed();
	}
	public PlantDashboard login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		
		return new PlantDashboard();
	}

}
