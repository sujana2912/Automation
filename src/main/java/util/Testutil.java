package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class Testutil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;


	public static String TestDataSheet_path="D:\\SUJANA\\Eclipsenew\\TestAutomation\\src\\main\\java\\testdata\\TestDataExcel.xlsx";

	static Workbook book;
	static Sheet sheet;

	public static Object[][] getTestData(String sheetname)
	{
		FileInputStream file = null;

		try {
			file = new FileInputStream(TestDataSheet_path);
			book=WorkbookFactory.create(file);
			
		} catch (FileNotFoundException e) {
            System.err.println("Excel file not found: " + TestDataSheet_path);
            e.printStackTrace();
            return null; 
        } catch (IOException e) {
            System.err.println("Error reading the Excel file.");
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (file != null) {
                    file.close(); // Close the file stream
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

		 sheet = book.getSheet(sheetname);
	        if (sheet == null) {
	            System.err.println("Sheet '" + sheetname + "' not found in the Excel file.");
	            return null;
	        }

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}

		return data;
	}
	
	public static void takeScreenshotAtEndOfTest(WebDriver driver, String testName) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir"); // Gets project directory
        String screenshotPath = currentDir + "/screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
        FileUtils.copyFile(scrFile, new File(screenshotPath));
        System.out.println("Screenshot saved: " + screenshotPath);
    }
	
	public static void click(String xpath)
	{
		WebElement click = driver.findElement(By.xpath(xpath));
		click.click();
	}
	
	public static void text(String xpath,String value)
	{
		WebElement text = driver.findElement(By.xpath(xpath));
		text.sendKeys(value);
	}
	
	public static void dropdown(WebElement xpath, String value)
	{
		Select s =new Select(xpath);
		s.selectByVisibleText(value);
	
	}
}
