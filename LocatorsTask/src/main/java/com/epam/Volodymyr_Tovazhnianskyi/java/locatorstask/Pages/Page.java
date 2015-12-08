package com.epam.Volodymyr_Tovazhnianskyi.java.locatorstask.Pages;


import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.Volodymyr_Tovazhnianskyi.java.locatorstask.TimeConstants.TimeConstants;

public class Page {

	WebDriver driver;
	
	public Page(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void gerUrl(String URL){
		driver.get(URL);
	}
	
	public WebElement findElement(By by){
		return driver.findElement(by);
	}
	
	public List<WebElement> findFewElements(By by){
		return driver.findElements(by);
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	  public void mouseOverElement(By by) {
		    Actions builder = new Actions(driver);
		    builder.moveToElement(findElement(by)).build().perform();
		  }
	
	public void driverTimeout(TimeConstants timeoutTime){
		//driver.manage().timeouts().implicitlyWait(timeoutTime.getTime(), TimeUnit.MILLISECONDS);
		try {
			Thread.sleep(timeoutTime.getTime());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void waitForElement(By by, TimeConstants expectedWaitingTime) throws TimeoutException{
		new WebDriverWait(driver, expectedWaitingTime.getTime()/1000)
	  .until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public boolean waifForElementAndCheckIfItIsAppeared(By by, TimeConstants expectedWaitingTime){
		try{
			waitForElement(by, expectedWaitingTime);
			return true;
		}catch (TimeoutException e){
			return false;
		}
	}
	
}
