package com.epam.Volodymyr_Tovazhnianskyi.java.locatorstask.tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.epam.Volodymyr_Tovazhnianskyi.java.locatorstask.Pages.LewisBasketPage;
import com.epam.Volodymyr_Tovazhnianskyi.java.locatorstask.Pages.LewisItemDataPage;
import com.epam.Volodymyr_Tovazhnianskyi.java.locatorstask.Pages.LewisMainPage;
import com.epam.Volodymyr_Tovazhnianskyi.java.locatorstask.Pages.LewisSearchResultPage;
import com.epam.Volodymyr_Tovazhnianskyi.java.locatorstask.Pages.LewisWishListPage;
import com.epam.Volodymyr_Tovazhnianskyi.java.locatorstask.TimeConstants.TimeConstants;



public class Tests {
	
	WebDriver driver = new FirefoxDriver();
	
	LewisMainPage mainPage;
	LewisSearchResultPage searchResultPage;
	LewisItemDataPage itemDataPage;
	LewisBasketPage basketPage;
	LewisWishListPage wishListPage;
	
	@Before
	public void beforeTests(){
		mainPage = new LewisMainPage(driver);
		searchResultPage = new LewisSearchResultPage(driver);
		itemDataPage = new LewisItemDataPage(driver);
		basketPage = new LewisBasketPage(driver);
		wishListPage = new LewisWishListPage(driver);
		
		mainPage.gerUrl("http://www.johnlewis.com/");
	}

//	@Test
//	public void addToWishList(){
//		//mainPage.getCheapPresentForThatB();
//		mainPage.signIn("lewislal@maildrop.cc", "SuperPassword1");
//		mainPage.searchGoods("Top Hat");
//		searchResultPage.showItemDataPage("Top Hat");
//		itemDataPage.addToWishList();
//		itemDataPage.driverTimeout(TimeConstants.THREE_SECONDS);
//		itemDataPage.checkWishListFromItemData();
//		assertTrue(wishListPage.checkIfSomethingIsPresentInWishList());
//	}
	
	@Test
	public void checkWishListFromMainPage(){
		mainPage.signIn("lewislal@maildrop.cc", "SuperPassword1");
		mainPage.searchGoods("Top Hat");
		searchResultPage.showItemDataPage("Top Hat");
		itemDataPage.addToWishList();
		itemDataPage.driverTimeout(TimeConstants.THREE_SECONDS);
		mainPage.checkWishList();
		wishListPage.checkFirstOfTheWishLists();
		wishListPage.deleteFirstItemInWishList();
		//assertTrue(wishListPage.checkIfSomethingIsPresentInWishList());
	}
	
//	@Test
//	public void hoverTest(){
//		//mainPage.signIn("lewislal@maildrop.cc", "SuperPassword1");
//		mainPage.getCheapPresentForThatB();
//		//assertFalse(wishListPage.checkIfSomethingIsPresentInWishList());
//	}

//	@Test
//	public void checkBasket(){
//		mainPage.searchGoods("Top Hat");
//		searchResultPage.showItemDataPage("Top Hat");
//		itemDataPage.addToBasket();
//		itemDataPage.driverTimeout(TimeConstants.THREE_SECONDS);
//		itemDataPage.checkBasketFromItemData();
//		//mainPage.checkBasket();
//		assertEquals(1, basketPage.checkAmountOfItemInBasket());
//	}
	
}
