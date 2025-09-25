package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import util.Testutil;

public class TestBase {

    protected static WebDriver driver;   // shared driver instance
    protected static Properties prop;

    // Constructor: load properties
    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream fi = new FileInputStream(
                    System.getProperty("user.dir") + "/src/main/resources/config/credential.properties"
            );
            prop.load(fi);
        } catch (IOException e) {
            System.out.println("Config file not found: " + e.getMessage());
        }
    }

    // Browser initialization
    public static void intialization() {
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } 
        // if needed: add Firefox/Edge here

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Testutil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Testutil.IMPLICIT_WAIT));

        driver.get(prop.getProperty("url"));
    }

    // Dropdown helper
    public static void dropdown(WebElement element, String value) {
        Select select = new Select(element);
        String correctedValue = value.replace("\u00A0", " "); // fix for non-breaking space
        select.selectByVisibleText(correctedValue);
    }
}
