package com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.pageclasses;

import org.openqa.selenium.By;

import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.contextdriver.ContextDriver;
import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.enums.MailData;

public class MailRuAccountMainPage extends MailRuAccountPages {

	public MailRuAccountMainPage(ContextDriver context) {
		super(context);
	}
	
	public boolean checkIfLogoutButtonIsVisible(){
		return context.driver.findElement(By.id(MailData.mailRuLogoutButtonIntoMainAccountPageId.getPath())).isDisplayed();
	}
	
	public int getAmountOfNewMessages(){
		String numberOfMessages = context.driver.findElement(By.id(MailData.mailRuNewMessageId.getPath())).getText();
		if (numberOfMessages.equals(""))
			return 0;
		else
			return Integer.parseInt(numberOfMessages);
	}
	
	public void clickWriteNewMessageButton(){
		context.driver.findElement(By.xpath(MailData.mailRuNewMessageXPath.getPath())).click();
	}

}
