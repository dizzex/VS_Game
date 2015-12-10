package com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.Tests;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.ContextDrivers.ContextDriver;
import com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.Enumerator.BrowserType;
import com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.Enumerator.TimeConstants;
import com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.PageObject.PageContainer;

public class Tests {
	
	ContextDriver driver = new ContextDriver(BrowserType.FIREFOX);

	PageContainer pageContainer = new PageContainer(driver);
	
	@Before
	public void beforeTests(){
		pageContainer.getMainPage().getPage("http://rozetka.com.ua/");
		pageContainer.getMainPage().loginIntoAccount("rozetkatestmail@gmail.com", "SuperPassword");
		pageContainer.getMainPage().timeoutDriver(TimeConstants.TWO_SECONDS);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
//	@After
//	public void afterTests(){
//		pageContainer.getMainPage().logoutFromAccount();
//	}
	
	@Test
	public void TestSearch(){
		pageContainer.getMainPage().search("Бита");
		pageContainer.getSearchResultPage().addFirstItemToCart();
		String nameOfItem = pageContainer.getSearchResultPage().getFirstItemName();
		//pageContainer.getSearchResultPage().deleteElementFromCart(nameOfItem);
		//Assert.assertTrue(pageContainer.getMainPage().checkIfLoggedIn());
	}
	
//	@Test
//	public void TestSearch(){
//		pageContainer.getMainPage().search("Бита");
//	}
	
	@Test
	public void TestLogout(){
		//pageContainer.getMainPage().loginIntoAccount("rozetkatestmail@gmail.com", "SuperPassword");
		//driver.driver.manage().timeouts().implicitlyWait(TimeConstants.TWO_SECONDS.getMilliseconds(), TimeUnit.MILLISECONDS);
		if (pageContainer.getMainPage().checkIfLoggedIn())
			pageContainer.getMainPage().logoutFromAccount();
		else
			JOptionPane.showMessageDialog(null, "Not logged in");
	}

}
