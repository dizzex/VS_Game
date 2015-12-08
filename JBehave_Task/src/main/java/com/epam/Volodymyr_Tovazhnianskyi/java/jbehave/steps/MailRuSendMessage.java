package com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.steps;

import javax.swing.JOptionPane;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.contextdriver.ContextDriver;
import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.pageclasses.MailRuAccountMainPage;
import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.pageclasses.MailRuMailWasSendConfirmationPage;
import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.pageclasses.MailRuMainPage;
import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.pageclasses.MailRuSendMailPage;

import junit.framework.Assert;

public class MailRuSendMessage extends Steps {

	private MailRuMainPage mailRuMainPageController;
	private MailRuAccountMainPage mailRuAccountMainPageController;
	private MailRuSendMailPage mailRuSendMailPageController;
	private MailRuMailWasSendConfirmationPage mailRuMailWasSendConfirmationPageController;

	public MailRuSendMessage(ContextDriver context) {
		mailRuAccountMainPageController = new MailRuAccountMainPage(context);
		mailRuSendMailPageController = new MailRuSendMailPage(context);
		mailRuMailWasSendConfirmationPageController = new MailRuMailWasSendConfirmationPage(context);
		mailRuMainPageController = new MailRuMainPage(context);
	}

	@Given("user logged in with $login and $password and on Write New Message page")
	public void login(String login, String password) {
		mailRuMainPageController.authorizationInMailRuWithUserLoginAndPassword(login, password);
		mailRuAccountMainPageController.clickWriteNewMessageButton();
	}

	@When("try to send data to fields and click button (adress: <targetEmail>, theme: <theme>, message: <message>)")
	public void findNewMessages(@Named("targetEmail") String email, @Named("theme") String theme,
			@Named("message") String message) {
		mailRuSendMailPageController.writeNewMailAndSendIt(email, theme, message);
	}

	@Then("letter should be send")
	public void checkIfLetterWasSend() {

		Assert.assertTrue(mailRuMailWasSendConfirmationPageController.checkIfMessageWasSend());
	}
}
