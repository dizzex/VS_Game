package com.epam.Volodymyr_Tovazhnianskyi.java.locatorstask.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LewisItemDataPage extends LewisPage{
	
	public LewisItemDataPage(WebDriver driver) {
		super(driver);
	}

	public static final By ADD_TO_CART = By.xpath(".//*[@id='prod-add-to-basket']/div[2]/div/fieldset[2]/div/span/input[11]");
	public static final By BASKET_BUTTON = By.xpath(".//*[@id='prod-add-to-basket']/div[3]/div[3]/ul/li[1]/a");
	
	public static final By ADD_TO_WISH_LIST = By.xpath(".//*[@id='save-product-to-cart']/section/div[7]/div/a/span[2]");
	public static final By CHECK_WISH_LIST = By.xpath(".//*[@id='save-product-to-cart']/section/div[7]/div/div[1]/ul/li/div/a[2]");
	
	public void addToBasket(){
		findElement(ADD_TO_CART).click();
	}
	
	public void checkBasketFromItemData(){
		findElement(BASKET_BUTTON).click();
	}
	
	public void addToWishList(){
		findElement(ADD_TO_WISH_LIST).click();
	}
	
	public void checkWishListFromItemData(){
		findElement(CHECK_WISH_LIST).click();
	}
}
