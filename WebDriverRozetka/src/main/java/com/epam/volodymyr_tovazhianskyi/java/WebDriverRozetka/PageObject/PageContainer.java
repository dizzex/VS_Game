package com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.PageObject;

import com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.ContextDrivers.ContextDriver;

public class PageContainer {
	
	MainPage mainPage;
	SearchResultPage searchResultPage;
	
	public PageContainer(ContextDriver driver){
		this.mainPage = new MainPage(driver);
		this.searchResultPage = new SearchResultPage(driver);
	}

	public MainPage getMainPage() {
		return mainPage;
	}
	
	public SearchResultPage getSearchResultPage() {
		return searchResultPage;
	}

}
