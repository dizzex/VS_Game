package com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.PageObject;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.openqa.selenium.By;

import com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.ContextDrivers.ContextDriver;
import com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.Enumerator.PathData;
import com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.Enumerator.TimeConstants;

public abstract class RozetkaPage extends Page {
	
	protected final static By CART_BUTTON = By.xpath(".//*[contains(@id,'cart_block')]/a");
	protected final static By ITEM_IN_CART = By.xpath(".//*[@id='cart-popup']/div/div[1]/div[2]/div/div[2]");
	protected final static By DELETE_ITEM_IN_CART = By.xpath(".//*[@id='cart-popup']/div/div[1]/div[2]/div/div[1]/a/img");
	protected final static By CONFIRM_DELETING_ITEM = By.xpath(".//*[@id='cart-popup']/div/div[1]/div[2]/div/div[1]/div/div/div[2]/a");
	protected final static By CLOSE_CART_WINDOW = By.xpath(".//*[@id='cart-popup']/a/img");
	
	protected final static By MainPageLoginIntoAccountFirstButton_second = By.xpath(".//*[@id='header_user_menu']/a");
	protected final static By MainPageLoginIntoAccountFirstButton = By.xpath(".//*[@id='header_user_menu_parent']/a");
	protected final static By LoginFormLoginField = By.xpath(".//*[contains(@id,'user-popup-parent')]/div/div/div/form/div[1]/div[2]/input");
	protected final static By LoginFormPasswordField = By.xpath(".//*[contains(@id,'user-popup-parent')]/div/div/div/form/div[1]/div[3]/div[1]/div[1]/input");
	protected final static By LoginFormSubmitButton = By.xpath(".//*[contains(@id,'user-popup-parent')]/div/div/div/form/div[1]/div[3]/div[1]/div[2]/div/span/button");
	protected final static By SearchTextField = By.xpath(".//*[@id='search']/form/div[1]/div[2]/input");
	protected final static By SearchButton = By.xpath(".//*[@id='search']/form/span/span");
	
	protected final static By LOGOUTBUTTON_fake = By.xpath(".//*[@id='header_user_menu']/li[10]/a");
	protected final static By LOGOUTBUTTON = By.xpath(".//*[@id='personal_information']/div/ul/li[3]/a");

	public RozetkaPage(ContextDriver driver) {
		super(driver);
	}
	
	public void deleteElementsFromCart(){
		clickOnElement(findElement(CART_BUTTON));
		try{
			waitForElementPresent(ITEM_IN_CART, TimeConstants.TEN_SECONDS);
			clickOnElement(findElement(DELETE_ITEM_IN_CART));
			//clickOnElement(findElement(CONFIRM_DELETING_ITEM));
		}catch(TimeoutException e){
			JOptionPane.showMessageDialog(null, "No items in the cart");
		}
		clickOnElement(findElement(CLOSE_CART_WINDOW));
	}
	
	public void hoverTest(){
		hoverOverElement(MainPageLoginIntoAccountFirstButton, LOGOUTBUTTON_fake);
	}
	
	public void logoutFromAccount(){
		try {
			waitForElementPresent(MainPageLoginIntoAccountFirstButton, TimeConstants.TWO_SECONDS);
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		//hoverOverElement(MainPageLoginIntoAccountFirstButton);
		clickOnElement(findElement(LOGOUTBUTTON_fake));
		//clickOnElement(findElement(MainPageLoginIntoAccountFirstButton));
		//clickOnElement(findElement(LOGOUTBUTTON));
	}
	
	public boolean checkIfLoggedIn(){
		if (findElement(MainPageLoginIntoAccountFirstButton).getText().contains("войдите в личный"))
			return false;
		else
			return true;
	}
	
	public void loginIntoAccount(String login, String password){
		contextDriver.driver.findElement(By.xpath(PathData.MainPageLoginIntoAccountFirstButtonXPath.getPath())).click();
		try {
			waitForElementPresent(LoginFormLoginField, TimeConstants.TEN_SECONDS);
		} catch (TimeoutException e) {
			System.out.println("No Form Lel");
		}
		fillInputLoginField(login);
		fillInputPasswordField(password);
		clickSubmitLoginButton();
	}

	public void search(String searchText){
		fillSearchField(searchText);
		clickSearchButton();		
	}
	
	private void fillInputLoginField(String login){
		writeIntoWebElement(findElement(LoginFormLoginField), login);
		//driver.findElement(By.xpath(PathData.LoginFormLoginFieldXPath.getPath())).sendKeys(login);
	}
	
	private void fillInputPasswordField(String password){
		writeIntoWebElement(findElement(LoginFormPasswordField), password);
		//driver.findElement(By.xpath(PathData.LoginFormPasswordFieldXPath.getPath())).sendKeys(password);
	}
	
	private void clickSubmitLoginButton(){
		clickOnElement(findElement(LoginFormSubmitButton));
		//driver.findElement(By.xpath(PathData.LoginFormSubmitButtonXPath.getPath())).click();
	}
	
	private void fillSearchField(String searchText){
		writeIntoWebElement(findElement(SearchTextField), searchText);
		//driver.findElement(By.xpath(PathData.SearchTextFieldXPath.getPath())).sendKeys(searchText);
	}
	
	private void clickSearchButton(){
		clickOnElement(findElement(SearchButton));
		//driver.findElement(By.xpath(PathData.SearchButtonXPath.getPath())).click();
	}
	
}
