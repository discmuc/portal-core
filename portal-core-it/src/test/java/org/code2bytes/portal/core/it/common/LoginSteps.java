package org.code2bytes.portal.core.it.common;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.code2bytes.portal.core.it.pages.LoginPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Singleton
public class LoginSteps {
	
	@Inject
	private LoginPage loginPage;

	@Given("^I browse to URL of the portal application$")
	public void i_browse_to_URL_of_the_portal_application() throws Throwable {
		loginPage.openLoginPage();
	}

	@Given("^I will be redirected to the login screen$")
	public void i_will_be_redirected_to_the_login_screen() throws Throwable {
		throw new PendingException();
	}

	@When("^I enter the credentials of the administrator$")
	public void i_enter_the_credentials_of_the_administrator() throws Throwable {
		throw new PendingException();
	}

	@When("^I enter the credentials of a user$")
	public void i_enter_the_credentials_of_a_user() throws Throwable {
		throw new PendingException();
	}

	@Then("^I should see the start page$")
	public void i_should_see_the_start_page() throws Throwable {
		throw new PendingException();
	}
}
