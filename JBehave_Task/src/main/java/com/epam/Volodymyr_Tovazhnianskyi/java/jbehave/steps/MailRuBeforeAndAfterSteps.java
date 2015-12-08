package com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.steps;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.steps.Steps;

import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.contextdriver.ContextDriver;
import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.pageclasses.MailRuMainPage;

public class MailRuBeforeAndAfterSteps extends Steps {

	MailRuMainPage mailRuMainPageController;

	public MailRuBeforeAndAfterSteps(ContextDriver context) {
		mailRuMainPageController = new MailRuMainPage(context);
	}

	@BeforeScenario
	public void loginInMailRu() {
		mailRuMainPageController.goToSelectedUrl("https://mail.ru/");
	}

	@AfterScenario
	public void logoutFromAccount() {
		mailRuMainPageController.logoutFromAccout();
	}

}
