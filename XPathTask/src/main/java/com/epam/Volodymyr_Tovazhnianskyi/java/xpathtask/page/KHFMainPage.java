package com.epam.Volodymyr_Tovazhnianskyi.java.xpathtask.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KHFMainPage extends Page{

	public KHFMainPage(WebDriver driver) {
		super(driver);
	}
	
	//private static final By LIST_OF_THEMES = By.xpath(".//*[@id='collapseobj_forumbit_56']/tr");
	//private static final By LIST_OF_THEMES = By.xpath(".//*[@id='collapseobj_forumbit_56']/tr[/td[text()>500]]");
	//private static final By LIST_OF_THEMES = By.xpath(".//*[@id='collapseobj_forumbit_56']/tr[td>500]");
	//private static final By LIST_OF_THEMES = By.xpath(".//*[@id='collapseobj_forumbit_56']/tr[1]/td[2]/div/a");
	private static final By LIST_OF_THEMES = By.xpath(".//*[@id='collapseobj_forumbit_56']/tr[td[4]=256]/td[2]/div/a");
	
	public List<WebElement> getAllThemes(){
		return findFewElements(LIST_OF_THEMES);
	}
	
	public WebElement getTheme(){
		return findElement(LIST_OF_THEMES);
	}
	
}
