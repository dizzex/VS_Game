package com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.pageclasses;

import org.openqa.selenium.By;

import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.contextdriver.ContextDriver;
import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.enums.MailData;

public class MailRuSendMailPage extends MailRuAccountPages {

	public MailRuSendMailPage(ContextDriver context) {
		super(context);
	}
	
	public void writeNewMailAndSendIt(String adress, String theme, String mailText){
		fillAdressFieldWithGivenString(adress);
		fillThemeFieldWithGivenString(theme);
		fillMailBodyFieldWithGivenString(mailText);
		clickSendMessageButton();
	}

	private void fillAdressFieldWithGivenString(String adress) {
		context.driver.findElement(By.xpath(MailData.mailRuAdressWhereToSendMessageXPath.getPath())).sendKeys(adress);
	}

	private void fillThemeFieldWithGivenString(String theme) {
		context.driver.findElement(By.xpath(MailData.mailRuThemeOfTheNewMessageId.getPath())).sendKeys(theme);
	}

	private void fillMailBodyFieldWithGivenString(String messageBody) {
		context.driver.switchTo()
				.frame(context.driver.findElement(By.xpath(MailData.mailRuMessageBodyIFrameXPath.getPath())));
		context.driver.findElement(By.id(MailData.mailRuBodyOfTheNewMessageId.getPath())).sendKeys(messageBody);
		context.driver.switchTo().defaultContent();
	}

	private void clickSendMessageButton() {
		context.driver.findElement(By.xpath(MailData.mailRuSendNewMessageXPath.getPath())).click();
	}

}
