package com.epam.Volodymyr_Tovazhnianskyi.java.xpathtask.demo;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.epam.Volodymyr_Tovazhnianskyi.java.xpathtask.page.KHFMainPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Demo {
	
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		KHFMainPage mainPage = new KHFMainPage(driver);
		mainPage.gerUrl("http://www.kharkovforum.com/");
		
//		List<WebElement> lElem = mainPage.getAllThemes();
//		
//	for (WebElement element: lElem){
//		System.out.println("Test");
//	}
		
		WebElement elem = mainPage.getTheme();

		System.out.println(elem.toString());

	}
	
}
