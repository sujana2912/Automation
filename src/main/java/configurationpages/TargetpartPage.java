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
	//	
	//	public void addTargetPart(String s1, String s2, String s3) throws InterruptedException {
	//	    List<String> values = Arrays.asList(s1, s2, s3);
	//
	//	    int totalMachines = driver.findElements(By.xpath("//table/tbody/tr")).size();  // count rows
	//
	//	    for (int i = 0; i < totalMachines; i++) {
	//	        // Re-fetch the list of edit buttons each time
	//	        List<WebElement> editButtons = driver.findElements(By.xpath("//button[contains(@class, 'edit')]"));
	//	        WebElement editButton = editButtons.get(i);
	//	        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
	//
	//	        // Re-fetch the target inputs (they're reused)
	//	        List<WebElement> targetInputs = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
	//	                By.xpath("//input[@placeholder='Target Part']")));
	//
	//	        for (int j = 0; j < values.size(); j++) {
	//	            WebElement input = targetInputs.get(j);
	//	            input.clear();
	//	            input.sendKeys(values.get(j));
	//	        }
	//
	//	        // Click the save button
	//	        WebElement saveBtn = driver.findElement(By.xpath("//i[@title=\\\"Save Target Part \\\"]"));
	//	        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
	//
	//	        // Wait for toast message
	//	        wait.until(ExpectedConditions.visibilityOfElementLocated(
	//	                By.xpath("//*[contains(text(),'TargetPart is updated')]")));
	//
	//	        Thread.sleep(1000);  // wait to allow DOM to settle
	//	    }
	//	}



//	public void addtargetpart(String s1, String s2, String s3)
//	{
//		for (int i = 0; i < clickedit.size(); i++) {
//			clickedit.get(i).click();
//
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			//clickedit.get(i).click();
//			for(int j=0; j< entertargetpart.size();j++)
//			{
//				WebElement x = entertargetpart.get(j);
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//				wait.until(ExpectedConditions.elementToBeClickable(entertargetpart.get(j))).click();;
//
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//				if(j==0)
//				{
//					x.sendKeys(s1);
//					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//				}
//				else if(j==1)
//				{
//					x.sendKeys(s2);
//					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//				}
//				else 
//				{
//					x.sendKeys(s3);
//					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//				}
//				savebtn.get(i).click();
//			}
//		}
//
//	}
	
	public void addtargetpart(String s1, String s2, String s3) {
        List<String> values = Arrays.asList(s1, s2, s3);
 
        for (int i = 0; i < clickedit.size(); i++) {
            // Step 1: Click edit for row i
            clickedit.get(i).click();
           System.out.println("hi");
 
            // Step 2: Wait for that row's input fields to appear
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@id='userA']")));
 
            // Step 3: Fetch the visible input fields (Shift-A, B, C)
            List<WebElement> inputFields = driver.findElements(By.xpath("//input[@id='userA']"));
 
            // Step 4: Use j-loop to send values to the input fields
            for (int j = 0; j < inputFields.size() && j < values.size(); j++) {
                WebElement input = inputFields.get(j);
                wait.until(ExpectedConditions.elementToBeClickable(input));
                input.clear();
                input.sendKeys(values.get(j));
            }
 
            // Step 5: Click the save button for the current row
            savebtn.get(i).click();
 
            // Optional: Wait after save if needed
            try {
                Thread.sleep(500); // wait for half a second for UI to reset
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}

}
