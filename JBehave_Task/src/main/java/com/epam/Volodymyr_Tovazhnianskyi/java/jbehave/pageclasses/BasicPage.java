package com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.pageclasses;

import java.util.concurrent.TimeUnit;

import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.contextdriver.ContextDriver;

public class BasicPage {
	
	protected ContextDriver context;
	
	public BasicPage(ContextDriver context){
		this.context = context;
	}
	
	public void waitSelectedAmountOfSeconds(int secondsToWait){
		context.driver.manage().timeouts().implicitlyWait(secondsToWait, TimeUnit.SECONDS);
	}
	
	public void goToSelectedUrl(String URL){
		context.driver.get(URL);
	}
	
	

}
