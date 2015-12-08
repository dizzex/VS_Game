package com.epam.Volodymyr_Tovazhnianskyi.java.locatorstask.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LewisBasketPage extends LewisPage {
	
	private static final By AMOUNT_OF_ITEMS_IN_BASKET = By.xpath(".//*[@id='basketForm']/div[3]/div[1]/div[1]/h1/span[2]/span");

	public LewisBasketPage(WebDriver driver) {
		super(driver);
	}
	
	public int checkAmountOfItemInBasket(){
		return Integer.parseInt(findElement(AMOUNT_OF_ITEMS_IN_BASKET).getText());
	}

}
