package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.Testutil;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

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
            // Auto-match the installed Chrome version
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            // Uncomment headless only if running in CI or you don't want UI
           // options.addArguments("--headless"); 
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            driver = new ChromeDriver(options); // create only once
        }

        // Maximize & set timeouts
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Testutil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Testutil.IMPLICIT_WAIT));

        driver.get(prop.getProperty("url"));
    }

    public static WebElement waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Dropdown helper
    public static void dropdown(WebElement element, String value) {
        Select select = new Select(element);
        String correctedValue = value.replace("\u00A0", " "); // fix for non-breaking space
        select.selectByVisibleText(correctedValue);
    }
}
