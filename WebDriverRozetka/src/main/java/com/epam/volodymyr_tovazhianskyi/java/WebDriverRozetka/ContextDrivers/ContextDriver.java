package com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.ContextDrivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.Enumerator.BrowserType;
import com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.Enumerator.TimeConstants;

public class ContextDriver{
	
	public WebDriver driver;
	
	public ContextDriver(BrowserType browserType) {
		driver = createDriver(browserType);
	}
	
	private WebDriver createDriver(BrowserType browserType){
		switch (browserType){
		case FIREFOX:
			return new FirefoxDriver();
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			return new ChromeDriver();
		default:
			throw new RuntimeException("Browser type unsupported");
		}
	}
	
	public void timeoutDriver(TimeConstants time){
		driver.manage().timeouts().implicitlyWait(time.getMilliseconds(), TimeUnit.SECONDS);
	}
}
