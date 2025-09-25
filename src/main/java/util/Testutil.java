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

    public static final long PAGE_LOAD_TIMEOUT = 20;
    public static final long IMPLICIT_WAIT = 10;

    // Excel file path (relative to project root)
    private static final String TEST_DATA_SHEET_PATH =
            System.getProperty("user.dir") + "/src/main/java/testdata/TestDataExcel.xlsx";

    private static Workbook book;
    private static Sheet sheet;

    // ============================= Excel Utilities ============================= //

    public static Object[][] getTestData(String sheetName) {
        try (FileInputStream fi = new FileInputStream(TEST_DATA_SHEET_PATH)) {
            book = WorkbookFactory.create(fi);
            sheet = book.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet '" + sheetName + "' not found in Excel file.");
            }

            int rows = sheet.getLastRowNum();
            int cols = sheet.getRow(0).getLastCellNum();
            Object[][] data = new Object[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
                }
            }
            return data;

        } catch (IOException e) {
            throw new RuntimeException("Failed to read test data: " + e.getMessage(), e);
        }
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
