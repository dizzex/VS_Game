package com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.PageObject;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;

import com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.ContextDrivers.ContextDriver;
import com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.Enumerator.TimeConstants;

public class SearchResultPage extends RozetkaPage{
	
	public final static By FirstItemAddToCartButton = By.xpath(".//*[@id='block_with_search']/div/div[1]/div[2]/div[4]/div/div/form/span/button");

	public SearchResultPage(ContextDriver driver) {
		super(driver);
	}

	public void addFirstItemToCart(){
		try{
			waitForElementPresent(FirstItemAddToCartButton, TimeConstants.TEN_SECONDS);
		}
		catch(TimeoutException e){
			System.out.println("No search result is visible");
		}
		clickOnElement(findElement(FirstItemAddToCartButton));
		
	}
	
}
