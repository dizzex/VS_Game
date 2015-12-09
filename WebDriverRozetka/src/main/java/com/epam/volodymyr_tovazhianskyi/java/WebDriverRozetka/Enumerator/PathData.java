package com.epam.volodymyr_tovazhianskyi.java.WebDriverRozetka.Enumerator;

public enum PathData {
	
	MainPageLoginIntoAccountFirstButtonXPath(".//*[@id='header_user_menu_parent']/a"),
	LoginFormLoginFieldXPath(".//*[contains(@id,'user-popup-parent')]/div/div/div/form/div[1]/div[2]/input"),
	LoginFormPasswordFieldXPath(".//*[contains(@id,'user-popup-parent')]/div/div/div/form/div[1]/div[3]/div[1]/div[1]/input"),
	LoginFormSubmitButtonXPath(".//*[contains(@id,'user-popup-parent')]/div/div/div/form/div[1]/div[3]/div[1]/div[2]/div/span/button"),
	SearchTextFieldXPath(".//*[@id='search']/form/div[1]/div[2]/input"),
	SearchButtonXPath(".//*[@id='search']/form/span/span");
	
	
	private final String linkPath;
	
	PathData(String path) {
		this.linkPath=path;
	}
	
	public String getPath(){
		return this.linkPath;
	}

}
