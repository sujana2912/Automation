package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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


	//public static String TestDataSheet_path="D:\\SUJANA\\Eclipsenew\\TestAutomation\\src\\main\\java\\testdata\\TestDataExcel.xlsx";

	static Workbook book;
	static Sheet sheet;

	public static Object[][] getTestData(String sheetname)
	{
		try {
		    FileInputStream fi = new FileInputStream(
		        System.getProperty("user.dir") + "/src/main/java/testdata/TestDataExcel.xlsx"
		    );
		    // Example: if you’re using Apache POI
		    XSSFWorkbook workbook = new XSSFWorkbook(fi);
		    System.out.println("Excel file loaded successfully!");
		} catch (IOException e) {
		    System.out.println("Test data file not found: " + e.getMessage());
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
	public static int getShiftCountFromExcel() {
        FileInputStream file = null;
        int shiftCount = 0;

        try {
            file = new FileInputStream(TestDataSheet_path);
            book = WorkbookFactory.create(file);
            sheet = book.getSheet("ShiftConfig"); // Sheet name from Excel

            if (sheet == null) {
                System.err.println("Sheet 'ShiftConfig' not found.");
                return 0;
            }

            shiftCount = sheet.getLastRowNum()-1; // excludes header
            System.out.println("Shift count from Excel: " + shiftCount);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return shiftCount;
    }
	public static List<List<String>> getTargetPartDataFromExcel() {
	    List<List<String>> targetPartData = new ArrayList<>();
	    FileInputStream file = null;
	    try {
	        file = new FileInputStream(TestDataSheet_path);
	        book = WorkbookFactory.create(file);
	        sheet = book.getSheet("TargetPartConfig");

	        if (sheet == null) {
	            System.err.println("TargetPart sheet not found!");
	            return null;
	        }

	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	            List<String> rowData = new ArrayList<>();
	            for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {
	                rowData.add(sheet.getRow(i).getCell(j).toString());
	            }
	            targetPartData.add(rowData);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (file != null) file.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    return targetPartData;
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
