package com.epam.Volodymyr_Tovazhnianskyi.java.locatorstask.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LewisPage extends Page {

	public LewisPage(WebDriver driver) {
		super(driver);
	}

	private final static By SEARCH_FIELD = By.xpath(".//*[@id='search-keywords']");
	private final static By SEARCH_BUTTON = By.xpath(".//*[@id='search-button-in-header']");
	
	private final static By SIGN_IN_BUTTON = By.xpath(".//*[@id='banner']/ul/li[1]/a[2]");
	
	private final static By EMAIL_LOGIN_FIELD = By.xpath(".//*[@id='email']");
	private final static By PASSWORD_LOGIN_FIELD = By.xpath(".//*[@id='password']");
	private final static By LOGIN_BUTTON = By.xpath(".//*[@id='mjl']/div[2]/div/form/fieldset/div[1]/input[5]");
	
	private final static By CHECKOUT_BASKET_BUTTON = By.xpath(".//*[@id='basket-wrapper']/div/ul/li[2]/a");
	
	private final static By WISH_LIST = By.xpath(".//*[@id='banner']/ul/li[3]/a");
	
	public void searchGoods(String searchText){
		findElement(SEARCH_FIELD).sendKeys(searchText);
		findElement(SEARCH_BUTTON).click();
	}
	
	public void checkBasket(){
		findElement(CHECKOUT_BASKET_BUTTON).click();
	}
	
	public void signIn(String login, String password){
		findElement(SIGN_IN_BUTTON).click();
		findElement(EMAIL_LOGIN_FIELD).sendKeys(login);
		findElement(PASSWORD_LOGIN_FIELD).sendKeys(password);
		findElement(LOGIN_BUTTON).click();
	}
	
	public void checkWishList(){
		findElement(WISH_LIST).click();
	}
	
}
