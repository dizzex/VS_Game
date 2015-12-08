package com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.steps;

import javax.swing.JOptionPane;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.contextdriver.ContextDriver;
import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.pageclasses.MailRuAccountMainPage;
import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.pageclasses.MailRuMainPage;

public class MailRuCheckMessageStep extends Steps {

	private MailRuMainPage mailRuMainPageController;
	private MailRuAccountMainPage mailRuAccountMainPageController;
	private int newMessages = 0;

	public MailRuCheckMessageStep(ContextDriver context) {
		mailRuAccountMainPageController = new MailRuAccountMainPage(context);
		mailRuMainPageController = new MailRuMainPage(context);
	}

	@Given("user logged in with $login and $password")
	public void login(String login, String password){
		mailRuMainPageController.authorizationInMailRuWithUserLoginAndPassword(login, password);
	}
	
	@When("user want to check new messages")
	public void findNewMessages() {

		newMessages = mailRuAccountMainPageController.getAmountOfNewMessages();
	}

	@Then("amount of new messages should appear")
	public void showHowMuchNewMessagesHeHas() {
		JOptionPane.showMessageDialog(null, "You have " + newMessages + " new messages");
	}

}
