package homePages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.TestBase;

public class ZoneDashboard extends TestBase {
	
	WebDriverWait wait;

	@FindBy(xpath = "//div[normalize-space()='Plant-1']")
	WebElement zonepagetitle;

	@FindBy(xpath = "//i[@class='fas fa-list']")
	WebElement listpattern;

	@FindBy(xpath = "//i[@class='fas fa-chart-line']")
	WebElement linepattern;

	@FindBy(xpath = "(//div[@class=\"card-header header-style text-center\"])[1]")
	WebElement clickmach1;

	public ZoneDashboard() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Verify Zone Dashboard title is displayed
	public boolean zdtitleTest() {
		wait.until(ExpectedConditions.visibilityOf(zonepagetitle));
		return zonepagetitle.isDisplayed();
	}

	// Click list and line patterns
	public void listlinepatternsTest() {
		wait.until(ExpectedConditions.elementToBeClickable(listpattern)).click();
		wait.until(ExpectedConditions.elementToBeClickable(linepattern)).click();
	}

	// Click a machine and move to Machine Dashboard
	public MachineDashboard clickmachTest() {
		wait.until(ExpectedConditions.elementToBeClickable(clickmach1)).click();
		// Wait for Machine Dashboard title or unique element
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Machine Dashboard')]")));
		return new MachineDashboard();
	}
}
