package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public static int getShiftCountFromExcel() {
        try (FileInputStream fi = new FileInputStream(TEST_DATA_SHEET_PATH)) {
            book = WorkbookFactory.create(fi);
            sheet = book.getSheet("ShiftConfig");

            if (sheet == null) {
                throw new RuntimeException("Sheet 'ShiftConfig' not found.");
            }

            return sheet.getLastRowNum() - 1; // Exclude header row

        } catch (IOException e) {
            throw new RuntimeException("Failed to read shift count: " + e.getMessage(), e);
        }
    }

    public static List<List<String>> getTargetPartDataFromExcel() {
        List<List<String>> targetPartData = new ArrayList<>();

        try (FileInputStream fi = new FileInputStream(TEST_DATA_SHEET_PATH)) {
            book = WorkbookFactory.create(fi);
            sheet = book.getSheet("TargetPartConfig");

            if (sheet == null) {
                throw new RuntimeException("Sheet 'TargetPartConfig' not found.");
            }

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                List<String> rowData = new ArrayList<>();
                for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {
                    rowData.add(sheet.getRow(i).getCell(j).toString());
                }
                targetPartData.add(rowData);
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to read target part data: " + e.getMessage(), e);
        }

        return targetPartData;
    }

    // ============================= Screenshot Utility ============================= //

    public static void takeScreenshotAtEndOfTest(WebDriver driver, String testName) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = System.getProperty("user.dir") +
                    "/screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
            FileUtils.copyFile(scrFile, new File(screenshotPath));
            System.out.println("Screenshot saved: " + screenshotPath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot: " + e.getMessage(), e);
        }
    }

    // ============================= Selenium Helpers ============================= //

    public static void click(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        waitForElementToBeClickable(element, 10).click(); // explicit wait
    }

    public static void text(String xpath, String value) {
        WebElement element = driver.findElement(By.xpath(xpath));
        WebElement visibleElement = waitForElementToBeVisible(element, 10);
        visibleElement.clear();
        visibleElement.sendKeys(value);
    }


}
