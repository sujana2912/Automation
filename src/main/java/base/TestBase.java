package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import util.Testutil;

public class TestBase {

	static public WebDriver driver;
	static public Properties prop;

	public TestBase()
	{
		try {
		prop = new Properties();
		FileInputStream fi = new FileInputStream("D:\\SUJANA\\Eclipsenew\\TestAutomation\\src\\main\\java\\config\\config.properties");
		prop.load(fi);
		} catch(IOException e) {
			System.out.println("filenotfound");
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
}
