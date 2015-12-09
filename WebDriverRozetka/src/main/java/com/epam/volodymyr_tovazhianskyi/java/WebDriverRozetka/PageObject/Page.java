package com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.PageObject;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.ContextDrivers.ContextDriver;
import com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.Enumerator.PathData;
import com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.Enumerator.TimeConstants;

public abstract class Page {
	
	ContextDriver contextDriver;

	public Page(ContextDriver cDriver) {
		contextDriver = cDriver;
	}

	public void getPage(String URL){
		contextDriver.driver.get(URL);
	}
	
	public WebElement findElement(By by){
		try{
			return contextDriver.driver.findElement(by);
		}catch (Exception ex){
			throw new RuntimeException(by.toString() + "isnt present on the Page");
		}
	}
	
	public void writeIntoWebElement(WebElement element, String text){
		element.sendKeys(text);
	}
	
	public void hoverOverElement(By by, By by2){
		Actions action = new Actions(contextDriver.driver);
		action.moveToElement(findElement(by)).perform();
		action.moveToElement(findElement(by2));
		action.click();
		action.build();
		//
	}
	
	public void waitForElementPresent(By by, TimeConstants waitingTime) throws TimeoutException{
			new WebDriverWait(contextDriver.driver, waitingTime.getMilliseconds()/1000)
			.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public void clickOnElement(WebElement element){
		element.click();
	}
	
	public void timeoutDriver(TimeConstants time){
		contextDriver.timeoutDriver(time);
	}
	
	public WebDriver getDriver(){
		return contextDriver.driver;
	}
	
}
