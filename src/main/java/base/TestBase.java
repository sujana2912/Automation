package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.Select;

import util.Testutil;

public class TestBase {

	static public WebDriver driver;
	static public Properties prop;

	public TestBase()
	{
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

	public static void intialization()
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
		driver = new ChromeDriver();
		}
			
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Testutil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Testutil.IMPLICIT_WAIT));
		
		
		driver.get(prop.getProperty("url"));
	}
	
	public static void dropdown(WebElement xpath, String value)
	{
		Select s =new Select(xpath);
		String correctedValue = value.replace("\u00A0", " ");
		s.selectByVisibleText(correctedValue);
		
	}
	
}
