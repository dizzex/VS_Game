package com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.contextdriver.ContextDriver;
import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.pageclasses.MailRuAccountMainPage;
import com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.pageclasses.MailRuMainPage;

import junit.framework.Assert;

public class MailRuLoginCheck extends Steps {

	MailRuMainPage mailRuMainPageController;
	MailRuAccountMainPage mailRuAccountMainPageController;
	
	String userLogin;
	String userPassword;

	public MailRuLoginCheck() {
	}

	public MailRuLoginCheck(ContextDriver context) {
		mailRuMainPageController = new MailRuMainPage(context);
		mailRuAccountMainPageController = new MailRuAccountMainPage(context);
	}
	
	@Given("user login is $login and password is $password")
	public void login(String login, String password){
		userLogin = login;
		userPassword = password;
	}

	@When("user tries to login into account")
	public void loginAsUser() {
		mailRuMainPageController.authorizationInMailRuWithUserLoginAndPassword(userLogin, userPassword);
	}

	@Then("there should be menu options")
	public void checkIfMenuIsPresent() {

		Assert.assertTrue(mailRuAccountMainPageController.checkIfLogoutButtonIsVisible());
	}
}
