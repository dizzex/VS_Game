package com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.contextdriver.ContextDriver;
import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.enums.MailData;

public class MailRuMailWasSendConfirmationPage extends MailRuAccountPages {

	public MailRuMailWasSendConfirmationPage(ContextDriver context) {
		super(context);
	}

	public boolean checkIfMessageWasSend() {
		WebDriverWait wait = new WebDriverWait(context.driver, 10);

		try {
			WebElement element = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(MailData.mailRuMailWasSendConfirmationXPath.getPath())));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}
}
