package com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.PageObject;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;

import com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.ContextDrivers.ContextDriver;
import com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.Enumerator.TimeConstants;

public class SearchResultPage extends RozetkaPage{
	
	private final static String FIRST_SEARCHED_ITEM = "//div[contains(@class,'g-i-list available')][1]";
	private final static String ADD_TO_CART = "//button[contains(@class,'btn-link-i')]";
	private final static String ITEM_TITLE = "//div[contains(@class,'g-i-list-title')]/a";
	
	
	public SearchResultPage(ContextDriver driver) {
		super(driver);
	}

	public void addFirstItemToCart(){
		try{
			waitForElementPresent(By.xpath(FIRST_SEARCHED_ITEM), TimeConstants.TEN_SECONDS);
		}
		catch(TimeoutException e){
			System.out.println("No search result is visible");
		}
		clickOnElement(findElement(By.xpath(FIRST_SEARCHED_ITEM.concat(ADD_TO_CART))));
	}
	
	public String getFirstItemName(){
		return findElement(By.xpath(FIRST_SEARCHED_ITEM.concat(ITEM_TITLE))).getText();
	}
	
}
