package com.qa.testBase;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.utils.TestUtils;
import com.qa.utils.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		prop=new Properties();
		FileInputStream FIS = null;
		try {
			FIS = new FileInputStream("C:\\Framework_Projects\\FreeCRM_Project"
					+ "\\src\\main\\java\\com\\qa\\config\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(FIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initialization() {
		String BrowserName=prop.getProperty("browser");
		
		// Browser Selection
		if(BrowserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\Framework_Projects"
				+ "\\FreeCRM_Project\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
	    }
		else if(BrowserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver","C:\\Framework_Projects"
					+ "\\FreeCRM_Project\\Driver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGELOAD_TIMEOUTS, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT_TIMEOUTS, TimeUnit.SECONDS);
		
		driver.navigate().to(prop.getProperty("url"));

	}
}
