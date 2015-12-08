package com.epam.Volodymyr_Tovazhnianskyi.java.locatorstask.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LewisSearchResultPage extends LewisPage {
	
	public LewisSearchResultPage(WebDriver driver) {
		super(driver);
	}

	public final static By SEARCHED_ITEM_PATTERN = By.xpath(".//*[contains(@id, 'product-link']/img");
	
	
	public void showItemDataPage(String itemName){
		//final By SEARCHED_ITEM = By.xpath(".//*[contains(text(), '" + itemName + "')]/preceding-sibling::div/a/img");
		//final By SEARCHED_ITEM = By.xpath(".//*[contains(text(), '" + itemName + "')]");
		final By SEARCHED_ITEM = By.xpath(".//*[contains(text(), 'Top Hat')]");
		
		findElement(SEARCHED_ITEM).click();
	}
	
}
