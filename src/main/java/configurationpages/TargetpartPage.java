package configurationpages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import util.Testutil;

public class TargetpartPage extends TestBase {

	@FindBy(xpath="//button[contains(@title,'Edit Target Part')]")
	List<WebElement> clickedit;

	@FindBy(xpath="//input[@id=\"userA\"]")
	List<WebElement> entertargetpart;

	@FindBy(xpath="//i[@title=\"Save Target Part \"]")
	List<WebElement> savebtn;

	public TargetpartPage() {

		PageFactory.initElements(driver, this);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public void addtargetpart() throws InterruptedException {
		List<List<String>> targetPartValues = Testutil.getTargetPartDataFromExcel();
		int shiftCount = Testutil.getShiftCountFromExcel();
		System.out.println(targetPartValues.size());
		for (int i = 0; i < clickedit.size(); i++) {
			clickedit.get(i).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			System.out.println("Clicked edit for machine " + (i + 1));

			List<String> machineTargetParts = targetPartValues.get(i);

			for (int j = 0; j < shiftCount; j++) {
				int inputFieldIndex = (i * shiftCount) + j;
				WebElement inputField = entertargetpart.get(inputFieldIndex);
				inputField.sendKeys(machineTargetParts.get(j));
				Thread.sleep(1000);
				System.out.println("Entered " + machineTargetParts.get(j) + " at index: " + inputFieldIndex);
				Thread.sleep(2000);
			}
			if (i < savebtn.size()) {
				savebtn.get(i).click();
				System.out.println("Clicked save for machine " + (i + 1));
			} else {
				System.out.println("Save button not found for machine " + (i + 1));
			}
		}
	}
}

