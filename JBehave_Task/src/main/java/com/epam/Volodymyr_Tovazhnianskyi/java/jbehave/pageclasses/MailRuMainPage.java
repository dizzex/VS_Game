package com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.contextdriver.ContextDriver;
import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.enums.MailData;

public class MailRuMainPage extends MailRuAccountPages {

	public MailRuMainPage(ContextDriver context) {
		super(context);
	}

	public void waitForShit() {
		WebDriverWait wait = new WebDriverWait(context.driver, 20);

		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.id(MailData.mailRuLoginFieldId.getPath())));
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id(MailData.mailRuPasswordFieldId.getPath())));
	}

	public void goToMainPageAndLogin(String login, String password) {
		goToSelectedUrl("https://mail.ru/");
		authorizationInMailRuWithUserLoginAndPassword(login, password);
	}

	public void logoutFromAccout() {
		goToSelectedUrl("https://mail.ru/");
		context.driver.findElement(By.id(MailData.mailRuLogoutId.getPath())).click();
	}

	public void authorizationInMailRuWithUserLoginAndPassword(String login, String password) {
		context.driver.findElement(By.id(MailData.mailRuLoginFieldId.getPath())).clear();
		context.driver.findElement(By.id(MailData.mailRuLoginFieldId.getPath())).sendKeys(login);
		context.driver.findElement(By.id(MailData.mailRuPasswordFieldId.getPath())).sendKeys(password);
		context.driver.findElement(By.id(MailData.mailRuLoginButtonId.getPath())).click();
	}

}
