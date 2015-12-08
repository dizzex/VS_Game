package com.epam.Volodymyr_Tovazhnianskyi.java.locatorstask.Pages;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.epam.Volodymyr_Tovazhnianskyi.java.locatorstask.TimeConstants.TimeConstants;

public class LewisMainPage extends LewisPage {

	public LewisMainPage(WebDriver driver) {
		super(driver);
	}
	
	private static final By WOMAN_DROPDOWN = By.xpath(".//*[@id='nn-nav-menu']/ul/li[4]/a/span[2]");
	private static final By CHEAP_PRESENT = By.xpath(".//*[@id='nn-nav-menu']/ul/li[4]/div/div[3]/ul/li[11]/a");
	
	public void getCheapPresentForThatB(){
		mouseOverElement(WOMAN_DROPDOWN);
		
    	try {
			waitForElement(CHEAP_PRESENT, TimeConstants.TWO_SECONDS);
			findElement(CHEAP_PRESENT).click();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
}
