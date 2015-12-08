package com.epam.Volodymyr_Tovazhnianskyi.java.locatorstask.Pages;

import java.util.concurrent.TimeoutException;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.epam.Volodymyr_Tovazhnianskyi.java.locatorstask.TimeConstants.TimeConstants;

public class LewisWishListPage extends LewisPage {
	
	public LewisWishListPage(WebDriver driver) {
		super(driver);
	}

	private static final By FIRST_OF_THE_WISH_LISTS = By.xpath(".//*[@id='wlist-overview']/div[2]/div[1]/div[1]/div[2]/a/span/span");
	private static final By DELETE_FIRST_OF_THE_WISH_LIST_ITEM = By.xpath(".//*[@id='wlist-grid-view']/section/form/div[3]/a");
	private static final By DELETE_FIRST_OF_THE_WISH_LIST_ITEM_CONFIRMATION = By.xpath(".//*[@id='wlist-grid-view']/section/form/div[3]/div/ul/li[1]/a");
	
	private static final By AMOUNT_OF_ITEMS_IN_WISH_LIST = By.xpath(".//*[@id='wlist']/div/div[2]/section[2]/h2");
	
	public void checkFirstOfTheWishLists(){
		if (waifForElementAndCheckIfItIsAppeared(FIRST_OF_THE_WISH_LISTS, TimeConstants.THREE_SECONDS))
			findElement(FIRST_OF_THE_WISH_LISTS).click();
		else
			JOptionPane.showMessageDialog(null, "There is no wish lists");
	}
	
	public boolean checkIfSomethingIsPresentInWishList(){
		try{
			waitForElement(AMOUNT_OF_ITEMS_IN_WISH_LIST, TimeConstants.ONE_SECOND);
			return true;
		}catch(TimeoutException e){
			return false;
		}
	}
	
	public void deleteFirstItemInWishList(){
		findElement(DELETE_FIRST_OF_THE_WISH_LIST_ITEM).click();
		findElement(DELETE_FIRST_OF_THE_WISH_LIST_ITEM_CONFIRMATION).click();
	}
}
