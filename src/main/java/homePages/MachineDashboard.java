package homePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class MachineDashboard extends TestBase {
	
	@FindBy(xpath="//body[1]/app-root[1]/app-mainpage[1]/div[1]/main[1]/div[1]/app-drilldown[1]/div[2]/div[1]/app-pms[1]/div[1]/div[1]/div[2]/div[1]/div[1]/app-piechart[1]/div[1]/div[1]/*[name()='svg']/*[name()='g']/*[name()='g']/*[name()='g']/*[name()='g']/*[name()='g']/*[name()='g']/*[name()='g']/*[name()='g']/*[name()='g']/*[name()='g']/*[name()='g']/*[name()='g']/*[name()='g']/*[name()='g']/*[name()='g']/*[name()='g']/*[name()='g']/*[name()='path']")
	WebElement gnattchart;
	
	public MachineDashboard()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void gnattchartbar()
	{
		Actions a = new Actions(driver);
		Actions pp = a.moveToElement(gnattchart);
		pp.click().build().perform();
	}

}
